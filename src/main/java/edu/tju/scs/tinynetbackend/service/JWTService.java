package edu.tju.scs.tinynetbackend.service;

import com.auth0.jwt.JWT;
import edu.tju.scs.tinynetbackend.common.FileHelper;
import edu.tju.scs.tinynetbackend.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.dto.ResponseData;
import edu.tju.scs.tinynetbackend.mapper.UserMapper;
import edu.tju.scs.tinynetbackend.po.User;
import edu.tju.scs.tinynetbackend.utils.RedisUtil;
import edu.tju.scs.tinynetbackend.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 22:33 18/12/10.
 */
@Slf4j
@Service
public class JWTService {

    @Autowired
    protected UserMapper userMapper;

    @Autowired
    protected RedisUtil redisUtil;

    public ErrorReport login(String username, String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = userMapper.selectByPrimaryKey(username);
        log.info("login parameters = {}, {} ",username,password);
        if(user != null && passwordEncoder.matches(password, user.getPassword())){
            log.info("user information = {}", user.toString());
            String token = TokenUtil.getToken(user.getPassword(),username);
            boolean result = redisUtil.setAndExpire(username,token);
            if(result){
                return new ErrorReport(0,"success",new ResponseData().addData("token",token));
            } else {
                return new ErrorReport(1, "login failed for error");
            }
        } else {
            return new ErrorReport(1, "no such username or password error");
        }
    }

    public ErrorReport logout(HttpServletRequest request){
        String token = request.getHeader("token");
        String audience = JWT.decode(token).getAudience().get(0);
        if(isLogin(token) && redisUtil.del(audience)){
            return new ErrorReport(0,"success");
        } else {
            return new ErrorReport(1, "logout failed for error");
        }
    }

    public boolean isLogin(String token){
        String audience = JWT.decode(token).getAudience().get(0);
        User user = userMapper.selectByPrimaryKey(audience);
        log.info("logout token audience : {}, {} ", audience ,user);
        if(user == null || !TokenUtil.parseToken(user.getPassword(),user.getUsername(),token)) {
            return false;
        }
        String sessionToken = redisUtil.get(audience);
        if(sessionToken != null && sessionToken.equals(token)){
            return true;
        }
        return false;

    }

    public ErrorReport reg(String username, String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        password = passwordEncoder.encode(password);
        if (userMapper.exist(username) == 0) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            // todo 用户类型
            userMapper.insert(user);
            FileHelper.createUser(username);
            return new ErrorReport(0, "success");
        } else {
            return new ErrorReport(3, "duplication error");
        }
    }

}
