package com.homeward.webstore.aop.namedpointcuts;


import org.aspectj.lang.annotation.Pointcut;

public class DatabaseLogPoint {

    @Pointcut(
            value = "execution(void com.homeward.webstore.mapper.PlayerInfoMapper.addPlayer(..)) && args(uuid, name, legacy))",
            argNames = "uuid, name, legacy"
    )
    public void OnUserInfoAddedInDataBase(String uuid, String name, Boolean legacy) {}
}
