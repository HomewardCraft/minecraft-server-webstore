package com.homeward.webstore.aop.advice;

import com.homeward.webstore.VO.R;
import com.homeward.webstore.common.enums.StatusEnum;
import com.homeward.webstore.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class CustomExceptionCatch {
    @Around("com.homeward.webstore.aop.pointcuts.CustomExceptionCatch.orderControllerMethod()")
    public R CartException(ProceedingJoinPoint point) {
        String uuid = JwtUtil.getUserId();
        R res;
        try {
            res = (R) point.proceed();
        } catch (Throwable throwable) {
            String errorMessage = throwable.getMessage();
            switch (errorMessage) {
                case "no such cart to update" -> {
                    log.warn("{} need a cart to update", uuid);
                    return R.no(StatusEnum.CART_CANNOT_UPDATE);
                }
                case "duplicated cart found" -> {
                    log.warn("{} have duplicated cart", uuid);
                    return R.no(StatusEnum.COLUMN_DUPLICATE);
                }
                case "no such cart to delete" -> {
                    log.warn("{} need a cart to delete", uuid);
                    return R.no(StatusEnum.CART_CANNOT_DELETE);
                }
                case "item not found" -> {
                    log.warn("{} query a void item", uuid);
                    return R.no(StatusEnum.ITEM_NOT_EXIST);
                }
                case "form data key not found" -> {
                    log.warn("{} give an invalid form data", uuid);
                    return R.no(StatusEnum.FORM_DATA_INVALID);
                }
                case "item amount out of bounds" -> {
                    log.warn("{} give a invalid amount", uuid);
                    return R.no(StatusEnum.VALUE_AMOUNT_INVALID);
                }
                case "database error" -> {
                    log.error("database has an error");
                    return R.no(StatusEnum.DATABASE_ERROR);
                }
                case "token not found" -> {
                    log.warn("token not found from {}", uuid);
                    return R.no(StatusEnum.JWT_HAS_EXPIRED);
                }
                case "wrong prefix" -> {
                    log.warn("{} has a token with wrong prefix", uuid);
                    return R.no(StatusEnum.WRONG_PREFIX);
                }
                case "jwt has expired" -> {
                    log.warn("{} has an expired token", uuid);
                    return R.no(StatusEnum.JWT_HAS_EXPIRED);
                }
                default -> {
                    log.error("unexpected exception");
                    throwable.printStackTrace();
                    return R.no(StatusEnum.UNEXPECTED_EXCEPTION);
                }
            }
        }
        return res;
    }

//    @Around("execution(* com.homeward.webstore.common.utils.JwtUtil.*(*))")
//    public R JWTException(ProceedingJoinPoint point) {
//        Object res;
//        try {
//            res = point.proceed();
//        } catch (Throwable e) {
//            switch () {
//
//            }
//        }
//        return res;
//    }
}
