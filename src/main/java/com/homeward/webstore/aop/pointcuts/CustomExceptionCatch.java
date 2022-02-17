package com.homeward.webstore.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class CustomExceptionCatch {

    @Pointcut("execution(" +
            "@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
            "com.homeward.webstore.VO.R " +
            "com.homeward.webstore.controller.OrderController.*(..))")
    public void orderControllerMethod() {}
}
