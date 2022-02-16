package com.homeward.webstore.config;

import com.homeward.webstore.handler.interceptor.LoginInterceptor;
import com.homeward.webstore.handler.interceptor.OrderCreateInterceptor;
import com.homeward.webstore.handler.interceptor.OrderDeleteInterceptor;
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
    private final OrderDeleteInterceptor orderDeleteInterceptor;

    public ViewConfig(LoginInterceptor loginInterceptor, OrderCreateInterceptor orderCreateInterceptor, OrderUpdateInterceptor orderUpdateInterceptor, OrderDeleteInterceptor orderDeleteInterceptor) {
        this.loginInterceptor = loginInterceptor;
        this.orderCreateInterceptor = orderCreateInterceptor;
        this.orderUpdateInterceptor = orderUpdateInterceptor;
        this.orderDeleteInterceptor = orderDeleteInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //想访问得登录
        InterceptorRegistration loginInterceptor = registry.addInterceptor(this.loginInterceptor);
        loginInterceptor.addPathPatterns(
                "/**"
        );
        loginInterceptor.excludePathPatterns(
                "/RedirectPage.html",
                "/home",
                "/emituofo.txt",
                "/category/**",
                "/name/*"
        );


        //想创建订单先得保证没有订单
        InterceptorRegistration orderCreateInterceptor = registry.addInterceptor(this.orderCreateInterceptor);
        orderCreateInterceptor.addPathPatterns(
                "/order/insert/*"
        );


        //想改订单数先得保证有订单
        InterceptorRegistration orderUpdateInterceptor = registry.addInterceptor(this.orderUpdateInterceptor);
        orderUpdateInterceptor.addPathPatterns(
                "/order/update"
        );

        //想删订单数先得保证有订单
        InterceptorRegistration orderDeleteInterceptor = registry.addInterceptor(this.orderDeleteInterceptor);
        orderDeleteInterceptor.addPathPatterns(
                "/order/delete/*"
        );
    }
}

