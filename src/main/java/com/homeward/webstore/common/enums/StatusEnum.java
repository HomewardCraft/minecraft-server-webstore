package com.homeward.webstore.common.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusEnum implements BaseEnum {
    //default
    SUCCESS(200, "success"),
    FAILURE(500, "failure"),

    //cart
    FORM_DATA_INVALID(400, "form data key not found"),
    VALUE_AMOUNT_INVALID(403, "item amount out of bounds"),
    ITEM_NOT_EXIST(500, "item not found"),
    COLUMN_DUPLICATE(500, "duplicated cart found"),
    CART_CANNOT_UPDATE(500, "no such cart to update"),
    CART_CANNOT_DELETE(500, "no such cart to delete"),

    //GG
    DATABASE_ERROR(500, "database in error"),

    //I don't know
    UNEXPECTED_EXCEPTION(500, "unexpected exception"),

    //token
    USER_UNVERIFIED(401, "user not verified"),
    JWT_NOT_FOUND(403, "token not found"),
    WRONG_PREFIX(403, "wrong prefix"),
    JWT_HAS_EXPIRED(403, "jwt has expired");

    private final Integer statusCode;

    private final String statusMessage;

    @Override
    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public String getStatusMessage() {
        return statusMessage;
    }
}
