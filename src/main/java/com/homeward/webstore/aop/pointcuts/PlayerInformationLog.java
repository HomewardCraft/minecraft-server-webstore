package com.homeward.webstore.aop.pointcuts;


import org.aspectj.lang.annotation.Pointcut;

public class PlayerInformationLog {

    @Pointcut(
            value = "execution(void com.homeward.webstore.mapper.PlayerInfoMapper.insertPlayer(..)) && args(uuid, name, legacy))",
            argNames = "uuid, name, legacy"
    )
    public void OnUserInfoAddedInDataBase(String uuid, String name, Boolean legacy) {}
}
