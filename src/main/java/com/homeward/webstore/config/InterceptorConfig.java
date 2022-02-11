package com.homeward.webstore.config;

import com.homeward.webstore.aop.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:/interceptor.yml")
public class InterceptorConfig implements WebMvcConfigurer {

    @Value("${includePath:/**}")
    private List<String> includePath;

    @Value("${excludePath}")
    private List<String> excludePath;

    private final LoginInterceptor loginInterceptor;
    public InterceptorConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);
        interceptorRegistration.addPathPatterns(includePath);
        interceptorRegistration.excludePathPatterns(excludePath);
    }
}
