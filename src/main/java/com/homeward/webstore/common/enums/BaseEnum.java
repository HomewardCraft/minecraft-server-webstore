package com.homeward.webstore.common.enums;

public interface BaseEnum {
    default Integer getCode() {
        return null;
    }

    String getMessage();
}
