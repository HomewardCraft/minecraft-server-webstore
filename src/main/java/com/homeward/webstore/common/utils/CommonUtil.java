package com.homeward.webstore.common.utils;

import com.homeward.webstore.common.enums.BaseEnum;

/**
 * 一些其他的工具
 */
public class CommonUtil {
    /**
     * 传入枚举名字以获取枚举的信息, 并抛出一个信息与之相同的异常
     * @param baseEnum
     */
    public static void throwRuntimeException(BaseEnum baseEnum) {
        throw new RuntimeException(baseEnum.getStatusMessage());
    }
}
