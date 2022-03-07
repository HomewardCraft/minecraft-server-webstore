package com.homeward.webstore.common.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AdministratorStatusEnum implements BaseEnum {
    LOGIN_INFORMATION_ERROR(403, "login information error"),
    ADMINISTRATOR_INFORMATION_ERROR(403, "administrator information error");


    private final Integer statusCode;

    private final String statusMessage;

    @Override
    public Integer getCode() {
        return this.statusCode;
    }

    @Override
    public String getMessage() {
        return this.statusMessage;
    }
}
