package com.homeward.webstore.common.consts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SystemConst implements BaseConst{
    /**
     * 项目名称
     */
    PROJECT_NAME("webstore"),

    /**
     * 玩家购物车
     */
    PLAYER_CART("_cart"),

    /**
     * 玩家session
     */
    PLAYER_SESSION("_session"),

    /**
     * 请求头中令牌的key
     */
    AUTHORIZATION_NAME("Authorization"),

    /**
     * 请求头中令牌的value开头
     */
    AUTHORIZATION_PREFIX("Bearer ");

    private final String name;

    @Override
    public String getInformation() {
        return name;
    }
}
