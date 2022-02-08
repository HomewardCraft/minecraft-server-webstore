package com.homeward.webstore.util;

import java.util.HashMap;
import java.util.Map;
//请您加注释
public class JsonMap {
    public Map<String, String> getJsonMap(String originJsonObj){
        //移除json对象两头的大括号
        String replacedJsonObj = originJsonObj.replaceAll("[{}\"]", "");
        //创建一个map集合
        Map<String, String> stringHashMap = new HashMap<>();
        //以逗号拆分字符串, 每个部分被存放进新数组
        String[] firstSplitJsonObj = replacedJsonObj.split(",");
        //遍历数组
        for (String fsjo : firstSplitJsonObj) {
            //以:拆分数组中的字符串, 每个部分被存放进新数组
            String[] secondSplitJsonObj = fsjo.split(":");
            for (int i = 0; i < secondSplitJsonObj.length; i += 1) {
                //为map集合赋值
                stringHashMap.put(secondSplitJsonObj[0], secondSplitJsonObj[1]);
            }
        }
        //返回一个map对象
        return stringHashMap;
    }
}