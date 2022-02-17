package com.homeward.webstore.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class CustomExceptionCatch {

    @Pointcut("execution(" +
            "@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
            "com.homeward.webstore.VO.R " +
            "com.homeward.webstore.controller.OrderController.*(..))")
    public void orderControllerMethod() {}

    @Pointcut("execution(" +
            "@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
            "boolean " +
            "com.homeward.webstore.handler.interceptor.LoginInterceptor.preHandle(..))")
    public void jsonWebTokenMethod() {}
}
