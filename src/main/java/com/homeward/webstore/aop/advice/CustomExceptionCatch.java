package com.homeward.webstore.aop.advice;

import com.homeward.webstore.vo.R;
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
                    return R.no(StatusEnum.DUPLICATE_CART_FOUND);
                }
                case "no such cart to delete" -> {
                    log.warn("{} need a cart to delete", uuid);
                    return R.no(StatusEnum.CART_CANNOT_DELETE);
                }
                case "item not found" -> {
                    log.warn("{} query a void item", uuid);
                    return R.no(StatusEnum.ITEM_NOT_FOUND);
                }
                case "form data key not found" -> {
                    log.warn("{} give an invalid form data", uuid);
                    return R.no(StatusEnum.FORM_DATA_INVALID);
                }
                case "item amount out of bounds" -> {
                    log.warn("{} give a invalid amount", uuid);
                    return R.no(StatusEnum.ITEM_AMOUNT_INVALID);
                }
                case "database error" -> {
                    log.error("database has an error");
                    return R.no(StatusEnum.DATABASE_ERROR);
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

    @Around("com.homeward.webstore.aop.pointcuts.CustomExceptionCatch.jsonWebTokenMethod()")
    public boolean JWTException(ProceedingJoinPoint point) {
        try {
            point.proceed();
        } catch (Throwable throwable) {
            String errorMessage = throwable.getMessage();
            switch (errorMessage) {
                case "user not verified", "jwt has expired", "wrong prefix", "token not found" -> {
                    return false;
                }
                default -> {
                    throwable.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }
}
