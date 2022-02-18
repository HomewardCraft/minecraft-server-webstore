package com.homeward.webstore.aop.pointcuts;


import org.aspectj.lang.annotation.Pointcut;

public class PlayerInformationLog {

    @Pointcut(
            value = "execution(" +
                    "@com.homeward.webstore.aop.annotations.JoinPointSymbol " +
                    "Long " +
                    "com.homeward.webstore.mapper.PlayerInfoMapper.insertPlayer(..)) && " +
                    "args(uuid, name, createTime)",
            argNames = "uuid, name, createTime"
    )
    public void OnUserInfoAddedInDataBase(String uuid, String name, String createTime) {}
}
