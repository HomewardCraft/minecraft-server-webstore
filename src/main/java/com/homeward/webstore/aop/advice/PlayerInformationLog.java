package com.homeward.webstore.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;


@Slf4j
@Aspect
@Component
public class PlayerInformationLog {

    @AfterReturning(
            pointcut = "com.homeward.webstore.aop.pointcuts.PlayerInformationLog.OnUserInfoAddedInDataBase(uuid, name, createTime)",
            argNames = "uuid,name,createTime"
    )
    public void userAddedInDataBaseLog(String uuid, String name, String createTime) {
        String tableName = "player_info";
        String formattedInfo = String.format("\"%s\"的数据在\"%s\"被记录到了\"%s\"表中, 其\"uuid\"为\"%s\"", name, createTime, tableName, uuid);
        log.warn(formattedInfo);
    }
}
