package edu.tju.scs.tinynetbackend.common.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tju.scs.tinynetbackend.common.Annotaion.JWTAuth;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.mapper.UserMapper;
import edu.tju.scs.tinynetbackend.model.po.User;
import edu.tju.scs.tinynetbackend.service.JWTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 17:10 18/12/11.
 */
@Slf4j
public class JWTAuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    JWTService jwtService;

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("the current handler is {}", handler.toString());
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(!method.isAnnotationPresent(JWTAuth.class)){
            return true;
        } else {
            String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
            User user = jwtService.isLogin(token);
            if(user == null){
                // 请重新登录
                writeMsg(response,new ErrorReport(10,"there is no login information about you"));
                return false;
            }
            JWTAuth jwtAuth = method.getAnnotation(JWTAuth.class);
            String authorization = jwtAuth.value();
            if(JWTService.ADMIN_ROLE.equals(authorization) && user.getType() == 1){
                return true;
            }
            if(JWTService.USER_ROLE.equals(authorization) && user.getType() == 0){
                return true;
            }
            writeMsg(response,new ErrorReport(10,"the authorization is not correct"));
            return false;
        }
    }


    public void writeMsg(HttpServletResponse response, ErrorReport errorReport){
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writeValueAsString(errorReport);
            writer.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null) {
                writer.close();
            }
        }
    }
}
