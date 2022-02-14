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
            pointcut = "com.homeward.webstore.aop.namedpointcuts.DatabaseLogPoint.OnUserInfoAddedInDataBase(uuid, name, legacy)",
            argNames = "uuid, name, legacy"
    )
    public void userAddedInDataBaseLog(String uuid, String name, Boolean legacy) {
        String tableName = "player_info";
        String formattedInfo = String.format("\"%s\"的数据被记录到了\"%s\"中, 其uuid为\"%s\"", name, tableName, uuid);
        log.warn(formattedInfo);
    }
}
