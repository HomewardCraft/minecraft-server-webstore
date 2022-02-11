package com.homeward.webstore.config;

import com.homeward.webstore.handler.interceptor.OrderCreateInterceptor;
import com.homeward.webstore.handler.interceptor.LoginInterceptor;
import com.homeward.webstore.handler.interceptor.OrderUpdateInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ViewConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;
    private final OrderCreateInterceptor orderCreateInterceptor;
    private final OrderUpdateInterceptor orderUpdateInterceptor;
    public ViewConfig(LoginInterceptor loginInterceptor, OrderCreateInterceptor orderCreateInterceptor, OrderUpdateInterceptor orderUpdateInterceptor) {
        this.loginInterceptor = loginInterceptor;
        this.orderCreateInterceptor = orderCreateInterceptor;
        this.orderUpdateInterceptor = orderUpdateInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //像访问得登录
        InterceptorRegistration loginInterceptor = registry.addInterceptor(this.loginInterceptor);
        loginInterceptor.addPathPatterns("/**");
        loginInterceptor.excludePathPatterns("/RedirectPage.html");
        loginInterceptor.excludePathPatterns("/home");
        loginInterceptor.excludePathPatterns("/emituofo.txt");
        loginInterceptor.excludePathPatterns("/name/*");

        //想创建订单先得保证没有订单
        InterceptorRegistration orderCreateInterceptor = registry.addInterceptor(this.orderCreateInterceptor);
        orderCreateInterceptor.addPathPatterns("/checkout/packages/add/**");

        //想修改订单数先得保证有订单
        InterceptorRegistration orderUpdateInterceptor = registry.addInterceptor(this.orderUpdateInterceptor);
        orderUpdateInterceptor.addPathPatterns("/checkout/update");
        orderUpdateInterceptor.addPathPatterns("/checkout/packages/remove/**");
    }
}

