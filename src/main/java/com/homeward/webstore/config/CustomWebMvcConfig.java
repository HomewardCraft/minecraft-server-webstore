package com.homeward.webstore.config;

import com.homeward.webstore.handler.converter.DynamicMessageConverter;
import com.homeward.webstore.handler.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration

public class CustomWebMvcConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;

    public CustomWebMvcConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        DynamicMessageConverter dynamicMessageConverter = new DynamicMessageConverter(jsonConverter, stringConverter);
        converters.add(0, dynamicMessageConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration loginInterceptor = registry.addInterceptor(this.loginInterceptor);
        loginInterceptor.addPathPatterns(
                "/**"
        );
        loginInterceptor.excludePathPatterns(
                "/category/*",
                "/production/*",
                "/rule/*",
                "/name/*",
                "/admin/login"
        );
    }
}