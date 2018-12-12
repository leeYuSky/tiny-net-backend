package edu.tju.scs.tinynetbackend.service;

import edu.tju.scs.tinynetbackend.common.FileHelper;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseData;
import edu.tju.scs.tinynetbackend.mapper.UserMapper;
import edu.tju.scs.tinynetbackend.model.po.User;
import edu.tju.scs.tinynetbackend.common.utils.RedisUtil;
import edu.tju.scs.tinynetbackend.common.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 22:33 18/12/10.
 */
@Slf4j
@Service
public class JWTService {

    public static final String AUTHENTICATION_KEY = "token";

    public static final String ADMIN_ROLE = "admin";

    public static final String USER_ROLE ="user";

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
                return new ErrorReport(0,"success",new ResponseData().addData(AUTHENTICATION_KEY,token));
            } else {
                return new ErrorReport(1, "login failed for error");
            }
        } else {
            return new ErrorReport(1, "no such username or password error");
        }
    }

    public ErrorReport logout(HttpServletRequest request){
        String token = request.getHeader(AUTHENTICATION_KEY);
        String audience = TokenUtil.getAudience(token);
        if(isLogin(token) != null && redisUtil.del(audience)){
            return new ErrorReport(0,"success");
        } else {
            return new ErrorReport(1, "logout failed for error");
        }
    }

    public User isLogin(String token){
        String audience = TokenUtil.getAudience(token);
        User user = userMapper.selectByPrimaryKey(audience);
        log.info("isLogin token audience : {}, {} ", audience ,user);
        if(user == null || !TokenUtil.parseToken(user.getPassword(),user.getUsername(),token)) {
            return null;
        }
        String sessionToken = redisUtil.get(audience);
        if(sessionToken != null && sessionToken.equals(token)){
            return user;
        }
        return null;

    }

}
