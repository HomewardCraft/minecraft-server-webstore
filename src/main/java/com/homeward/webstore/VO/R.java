package com.homeward.webstore.VO;

import com.homeward.webstore.common.enums.BaseEnums;
import com.homeward.webstore.common.enums.StatusCode;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 结果集
 * 包含成功, 失败与自定义失败状态
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R implements Serializable {
    private Integer status;
    private String message;
    private Object data;

    private static R resultSet(Integer status, String message, Object data) {
        R res = new R();
        res.setStatus(status);
        res.setMessage(message);
        res.setData(data);
        return res;
    }

    public static R ok() {
        return resultSet(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), null);
    }

    public static R ok(String message) {
        return resultSet(StatusCode.SUCCESS.getCode(), message, null);
    }

    public static R ok(Object data) {
        return resultSet(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), data);
    }

    public static R ok(String message, Object data) {
        return resultSet(StatusCode.SUCCESS.getCode(), message, data);
    }

    public static R no() {
        return resultSet(StatusCode.FAIL.getCode(), StatusCode.FAIL.getMessage(), null);
    }

    public static R no(String message) {
        return resultSet(StatusCode.FAIL.getCode(), message, null);
    }

    public static R no(Object data) {
        return resultSet(StatusCode.FAIL.getCode(), StatusCode.FAIL.getMessage(), data);
    }

    public static R no(String message, Object data) {
        return resultSet(StatusCode.FAIL.getCode(), message, data);
    }

    public static R no(Integer code, String message, Object data) {
        return resultSet(code, message, data);
    }

    public static R no(BaseEnums baseEnums) {
        return resultSet(baseEnums.getCode(), baseEnums.getMessage(), null);
    }
}
