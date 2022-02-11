package com.homeward.webstore.config;

import com.homeward.webstore.aop.Interceptor.OrderCreateInterceptor;
import com.homeward.webstore.aop.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ViewConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;
    private final OrderCreateInterceptor orderCreateInterceptor;
    public ViewConfig(LoginInterceptor loginInterceptor, OrderCreateInterceptor orderCreateInterceptor) {
        this.loginInterceptor = loginInterceptor;
        this.orderCreateInterceptor = orderCreateInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration loginInterceptor = registry.addInterceptor(this.loginInterceptor);
        loginInterceptor.addPathPatterns("/**");
        loginInterceptor.excludePathPatterns("/RedirectPage.html");
        loginInterceptor.excludePathPatterns("/name/*");

        InterceptorRegistration orderCreateInterceptor = registry.addInterceptor(this.orderCreateInterceptor);
        orderCreateInterceptor.addPathPatterns("/checkout/packages/add/**");
    }
}

