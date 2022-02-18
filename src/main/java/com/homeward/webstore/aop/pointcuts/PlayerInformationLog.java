package com.homeward.webstore.aop.pointcuts;


import org.aspectj.lang.annotation.Pointcut;

public class PlayerInformationLog {

    @Pointcut(
            value = "execution(" +
                    "@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
                    "void " +
                    "com.homeward.webstore.mapper.PlayerInfoMapper.insertPlayer(String, String)) && " +
                    "args(uuid, name))",
            argNames = "uuid, name"
    )
    public void OnUserInfoAddedInDataBase(String uuid, String name) {}
}
