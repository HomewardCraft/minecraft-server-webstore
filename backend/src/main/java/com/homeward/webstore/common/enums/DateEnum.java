package com.homeward.webstore.common.enums;

import lombok.AllArgsConstructor;

/**
 * 日期的枚举类
 */
@AllArgsConstructor
public enum DateEnum implements BaseEnum{
    yyyyMMddHHmmss("yyyy-MM-dd HH:mm:ss");

    private final String format;

    @Override
    public String getMessage() {
        return this.format;
    }
}
