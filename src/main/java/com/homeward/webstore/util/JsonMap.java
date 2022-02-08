package com.homeward.webstore.util;

import java.util.HashMap;
import java.util.Map;
//请您加注释
public class JsonMap {
    public Map<String, String> getJsonMap(String originJsonObj){
        String replacedJsonObj = originJsonObj.replaceAll("[{}\"]", "");
        Map<String, String> stringHashMap = new HashMap<>();
        String[] firstSplitJsonObj = replacedJsonObj.split(",");
        for (String fsjo : firstSplitJsonObj) {
            String[] secondSplitJsonObj = fsjo.split(":");
            for (int i = 0; i < secondSplitJsonObj.length; i += 1) {
                stringHashMap.put(secondSplitJsonObj[0], secondSplitJsonObj[1]);
            }
        }
        return stringHashMap;
    }
}