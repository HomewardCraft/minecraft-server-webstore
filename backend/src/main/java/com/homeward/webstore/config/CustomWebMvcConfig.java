package com.homeward.webstore.config;

import com.homeward.webstore.handler.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;

    public CustomWebMvcConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //想访问得登录
        InterceptorRegistration loginInterceptor = registry.addInterceptor(this.loginInterceptor);
        loginInterceptor.addPathPatterns(
                "/**"
        );
        loginInterceptor.excludePathPatterns(
                "/category/**",
                "/name/*"
        );
    }
}

