package com.homeward.webstore.common.exceptions;

/**
 * 自定义异常-未登录异常
 */
public class UnLoginException extends RuntimeException {

    public UnLoginException(String message) {
        super(message);
    }
}