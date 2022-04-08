package com.homeward.webstore.common.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AdministratorStatusEnum implements BaseEnum {
    LOGIN_INFORMATION_ERROR(403, "login information error"),
    ADMINISTRATOR_INFORMATION_ERROR(403, "administrator information error"),

    FILE_NOT_FOUND(403, "file not found"),
    EXTEND_NAME_NOT_MATCH(403, "file extend name not match"),
    IMAGE_INFORMATION_ERROR(500, "an error occur during read image information"),

    ITEM_TYPE_NOT_MATCH(403, "item type not match"),
    ITEM_NAME_DUPLICATED(403, "item name duplicated"),

    BACKEND_ERROR(500, "unhandled error occurred");


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
