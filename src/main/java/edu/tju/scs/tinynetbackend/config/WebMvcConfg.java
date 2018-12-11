package edu.tju.scs.tinynetbackend.config;

import edu.tju.scs.tinynetbackend.common.Interceptor.JWTAuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 01:15 18/12/12.
 */
@Configuration
public class WebMvcConfg implements WebMvcConfigurer {

    /**
     * 自己定义的拦截器类
     *
     * @return
     */
    @Bean
    JWTAuthenticationInterceptor sysUserLoginInterceptor() {
        return new JWTAuthenticationInterceptor();
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sysUserLoginInterceptor());
    }
}

