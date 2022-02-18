package com.homeward.webstore.common.utils;

import com.homeward.webstore.common.enums.BaseEnum;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 一些其他的工具整合的类
 */
public class CommonUtil {
    /**
     * 返回当前的被格式化后的时间
     *
     * @param baseEnum
     * @return
     */
    public static String currentFormattedDate(BaseEnum baseEnum) {
        return new SimpleDateFormat(baseEnum.getMessage())
                .format(Calendar.getInstance().getTime());
    }

    /**
     * 传入枚举名字以获取枚举的信息, 并抛出一个信息与之相同的异常
     *
     * @param baseEnum
     */
    public static void throwRuntimeException(BaseEnum baseEnum) {
        throw new RuntimeException(baseEnum.getMessage());
    }
}
