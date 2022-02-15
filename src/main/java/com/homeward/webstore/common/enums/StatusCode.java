package com.homeward.webstore.common.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusCode implements BaseEnums{
    SUCCESS(200, "succeeded"),
    FAIL(500, "failed");



    private final Integer statusCode;

    private final String statusMessage;

    @Override
    public Integer getCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return statusMessage;
    }
}
