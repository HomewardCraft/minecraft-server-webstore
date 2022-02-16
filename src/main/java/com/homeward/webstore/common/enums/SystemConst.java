package com.homeward.webstore.common.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SystemConst{
    /**
     * 项目名称
     */
    SYSTEM_PROJECT_NAME("homeward_webstore"),

    /**
     * 用户订单
     */
    SYSTEM_USER_ORDER("homeward_order"),

    /**
     * 登录用户session
     */
    SYSTEM_USER_SESSION("systemUserSession"),

    /**
     * 请求头中令牌的key
     */
    SYSTEM_AUTHORIZATION_KEY("Authorization"),

    /**
     * 请求头中令牌的value开头
     */
    SYSTEM_AUTHORIZATION_HEAD("Bearer ");

    private final String name;

    public String getName() {
        return name;
    }
}
