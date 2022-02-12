package com.homeward.webstore.aop.namedpointcuts;


import org.aspectj.lang.annotation.Pointcut;

public class DatabaseLogPoint {

    @Pointcut(
            value = "execution(void com.homeward.webstore.mapper.PlayerInfoMapper.addPlayer(..)) )"
    )
    public void OnUserInfoAddedInDataBase() {}
}
