package com.homeward.webstore.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class CustomExceptionAdvice {

    @Pointcut("execution(" +
            "@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
            "com.homeward.webstore.java.bean.VO.R " +
            "com.homeward.webstore.controller.CartController.*(..))")
    public void orderControllerMethod() {}

    @Pointcut("execution(" +
            "@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
            "boolean " +
            "com.homeward.webstore.handler.interceptor.LoginInterceptor.preHandle(..))")
    public void jsonWebTokenMethod() {}

    @Pointcut("execution(" +
            "@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
            "com.homeward.webstore.java.bean.VO.R " +
            "com.homeward.webstore.controller.PlayerController.getPlayerProfile(..))")
    public void playerControllerMethod() {}

    @Pointcut("execution(" +
            "@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
            "com.homeward.webstore.java.bean.VO.R " +
            "com.homeward.webstore.controller.AdminAccountController.administratorLogin(..))")
    public void adminLoginMethod() {}

    @Pointcut("execution(@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
            "com.homeward.webstore.java.bean.VO.R " +
            "com.homeward.webstore.controller.AdminItemManipulationController.uploadImage(..))")
    public void uploadImageMethod() {}

    @Pointcut("execution(@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
            "com.homeward.webstore.java.bean.VO.R " +
            "com.homeward.webstore.controller.AdminItemManipulationController.unmountImage(..))")
    public void unmountImageMethod() {}

    @Pointcut("execution(@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
            "com.homeward.webstore.java.bean.VO.R " +
            "com.homeward.webstore.controller.AdminItemManipulationController.insertItem(..))")
    public void insertItemMethod() {}

    @Pointcut("execution(@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
            "com.homeward.webstore.java.bean.VO.R " +
            "com.homeward.webstore.controller.AdminItemManipulationController.updateItem(..))")
    public void updateItemMethod() {}
}
