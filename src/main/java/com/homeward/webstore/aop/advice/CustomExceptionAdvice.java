package com.homeward.webstore.aop.advice;

import com.homeward.webstore.common.enums.AdministratorStatusEnum;
import com.homeward.webstore.java.bean.VO.R;
import com.homeward.webstore.common.enums.StatusEnum;
import com.homeward.webstore.common.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 异常的切面处理
 */
@Slf4j
@Component
@Aspect
public class CustomExceptionAdvice {
    @Around("com.homeward.webstore.aop.pointcuts.CustomExceptionAdvice.orderControllerMethod()")
    public R CartException(ProceedingJoinPoint point) {
        String uuid = JwtUtils.getUUID();
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

    @Around("com.homeward.webstore.aop.pointcuts.CustomExceptionAdvice.jsonWebTokenMethod()")
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

    @Around("com.homeward.webstore.aop.pointcuts.CustomExceptionAdvice.playerControllerMethod()")
    public R PlayerInfoException(ProceedingJoinPoint point) {
        R res;
        try {
            res = (R) point.proceed();
        } catch (Throwable throwable) {
            String errorMessage = throwable.getMessage();
            switch (errorMessage) {
                case "illegal char found" -> {
                    return R.no(StatusEnum.ILLEGAL_CHAR);
                }
                case "player cannot be found" -> {
                    return R.no(StatusEnum.PLAYER_NOT_FOUND);
                }
                default -> {
                    log.error("unexpected exception");
                    throwable.printStackTrace();
                    return R.no(StatusEnum.UNEXPECTED_EXCEPTION);
                }
            }
        }
        return R.ok(res);
    }


    @Around("com.homeward.webstore.aop.pointcuts.CustomExceptionAdvice.adminLoginMethod()")
    public R AdministratorException(ProceedingJoinPoint point) {
        R res;
        try {
            res = (R) point.proceed();
        } catch (Throwable throwable) {
            String errorMessage = throwable.getMessage();
            switch (errorMessage) {
                case "administrator information error" -> {
                    return R.no(AdministratorStatusEnum.ADMINISTRATOR_INFORMATION_ERROR);
                }
                case "login information error" -> {
                    return R.no(AdministratorStatusEnum.LOGIN_INFORMATION_ERROR);
                }
                default -> {
                    log.error(errorMessage);
                    throwable.printStackTrace();
                    return R.no(StatusEnum.UNEXPECTED_EXCEPTION);
                }
            }
        }
        return R.ok(res);
    }



    @Around("com.homeward.webstore.aop.pointcuts.CustomExceptionAdvice.uploadImageMethod() || " +
            "com.homeward.webstore.aop.pointcuts.CustomExceptionAdvice.unmountImageMethod()")
    public R AdministratorImageManipulationException(ProceedingJoinPoint point) {
        R res;
        try {
            res = (R) point.proceed();
        } catch (Throwable throwable) {
            String errorMessage = throwable.getMessage();
            switch (errorMessage) {
                case "file not found" -> {
                    return R.no(AdministratorStatusEnum.FILE_NOT_FOUND);
                }
                case "file extend name not match" -> {
                    return R.no(AdministratorStatusEnum.EXTEND_NAME_NOT_MATCH);
                }
                case "an error occur during read image information" -> {
                    return R.no(AdministratorStatusEnum.IMAGE_INFORMATION_ERROR);
                }
                case "unhandled error occurred" -> {
                    log.error(errorMessage);
                    throwable.printStackTrace();
                    return R.no(AdministratorStatusEnum.BACKEND_ERROR);
                }
                default -> {
                    log.error(errorMessage);
                    throwable.printStackTrace();
                    return R.no(StatusEnum.UNEXPECTED_EXCEPTION);
                }
            }
        }
        return res;
    }

    @Around("com.homeward.webstore.aop.pointcuts.CustomExceptionAdvice.insertItemMethod() || " +
            "com.homeward.webstore.aop.pointcuts.CustomExceptionAdvice.updateItemMethod()")
    public R AdministratorItemManipulationException(ProceedingJoinPoint point) {
        R res;
        try {
            res = (R) point.proceed();
        } catch (Throwable throwable) {
            String errorMessage = throwable.getMessage();
            switch (errorMessage) {
                case "item name duplicated" -> {
                    return R.no(AdministratorStatusEnum.ITEM_NAME_DUPLICATED);
                }
                case "item type not match" -> {
                    return R.no(AdministratorStatusEnum.ITEM_TYPE_NOT_MATCH);
                }
                case "unhandled error occurred" -> {
                    log.error(errorMessage);
                    throwable.printStackTrace();
                    return R.no(AdministratorStatusEnum.BACKEND_ERROR);
                }
                default -> {
                    log.error(errorMessage);
                    throwable.printStackTrace();
                    return R.no(StatusEnum.UNEXPECTED_EXCEPTION);
                }
            }
        }
        return res;
    }
}
