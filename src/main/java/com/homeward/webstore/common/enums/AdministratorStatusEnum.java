package com.homeward.webstore.common.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AdministratorStatusEnum implements BaseEnum {
    LOGIN_INFORMATION_ERROR(403, "login information error"),
    ADMINISTRATOR_INFORMATION_ERROR(403, "administrator information error"),

    FILE_NOT_FOUND(500, "file not found"),
    EXTEND_NAME_NOT_MATCH(500, "file extend name not match"),
    IMAGE_INFORMATION_ERROR(500, "an error occur during read image information"),
    IMAGE_CREATE_ERROR(500, "an error occur during create image to local host"),

    DUPLICATE_IMAGE(403, "duplicate image found");


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
