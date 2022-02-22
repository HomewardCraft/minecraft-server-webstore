package com.homeward.webstore.aop.pointcuts;


import org.aspectj.lang.annotation.Pointcut;

public class PlayerInformationAdvice {

    @Pointcut(
            value = "execution(" +
                    "@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
                    "Long " +
                    "com.homeward.webstore.mapper.PlayerMapper.insertPlayer(..)) && " +
                    "args(uuid, name, createTime)",
            argNames = "uuid, name, createTime"
    )
    public void insertPlayerLog(String uuid, String name, String createTime) {}
}
