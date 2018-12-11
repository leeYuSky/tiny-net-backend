package edu.tju.scs.tinynetbackend.common.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 17:10 18/12/11.
 */
public class JWTAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



        return false;
    }
}
