package com.homeward.webstore.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class DatabaseLog {

    @AfterReturning(
            pointcut = "com.homeward.webstore.aop.namedpointcuts.DatabaseLogPoint.OnUserInfoAddedInDataBase() && args(uuid, playerName)",
            //与注解的字段一一对应
            argNames = "uuid,playerName"
    )
    public void userAddedInDataBaseLog(String uuid, String playerName) {
        String tableName = "player_info";
        String formattedInfo = String.format("\"%s\"的数据被记录到了\"%s\"中, 其uuid为\"%s\"", playerName, tableName, uuid);
        log.debug(formattedInfo);
    }
}
