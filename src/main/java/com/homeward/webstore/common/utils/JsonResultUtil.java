package com.homeward.webstore.common.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * json结果集的工具类
 */
@Getter
@Setter
public class JsonResultUtil<T> {
    /** 成功 */
    public static final int SUCCESS = 200;

    /** 没有登录 */
    public static final int NOT_LOGIN = 400;

    /** 发生异常 */
    public static final int EXCEPTION = 401;

    /** 系统错误 */
    public static final int SYS_ERROR = 402;

    /** 参数错误 */
    public static final int PARAMS_ERROR = 403;

    /** 不支持或已经废弃 */
    public static final int NOT_SUPPORTED = 410;

    /** AuthCode错误 */
    public static final int INVALID_AUTHCODE = 444;

    /** 太频繁的调用 */
    public static final int TOO_FREQUENT = 445;

    /** 未知的错误 */
    public static final int UNKNOWN_ERROR = 499;

    private int code;
    private String msg;
    private T data;



    public static JsonResultUtil build() {
        return new JsonResultUtil();
    }
    public static JsonResultUtil build(int code) {
        return new JsonResultUtil().code(code);
    }
    public static JsonResultUtil build(int code, String msg) {
        return new JsonResultUtil<String>().code(code).msg(msg);
    }
    public static <T> JsonResultUtil<T> build(int code, T data) {
        return new JsonResultUtil<T>().code(code).data(data);
    }
    public static <T> JsonResultUtil<T> build(int code, String msg, T data) {
        return new JsonResultUtil<T>().code(code).msg(msg).data(data);
    }

    public JsonResultUtil<T> code(int code) {
        this.code = code;
        return this;
    }
    public JsonResultUtil<T> msg(String msg) {
        this.msg = msg;
        return this;
    }
    public JsonResultUtil<T> data(T data) {
        this.data = data;
        return this;
    }


    public static JsonResultUtil ok() {
        return build(SUCCESS);
    }
    public static JsonResultUtil ok(String msg) {
        return build(SUCCESS, msg);
    }
    public static <T> JsonResultUtil<T> ok(T data) {
        return build(SUCCESS, data);
    }
    public static JsonResultUtil err() {
        return build(EXCEPTION);
    }
    public static JsonResultUtil err(String msg) {
        return build(EXCEPTION, msg);
    }

    @Override
    public String toString() {
        return JsonUtil.to(this);
    }
}
