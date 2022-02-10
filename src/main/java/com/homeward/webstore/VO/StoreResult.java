package com.homeward.webstore.VO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//此对象为传给前端的最终json集
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class StoreResult implements Serializable {
    //是否错误
    private Boolean error;
    //分类名称
    private String name;
    //分类描述
    private String description;
    //分类展示方法
    private String display;
    //商品包含的中分类
    private Object packages;

    public static StoreResult fail() {
        return new StoreResult(true, "", "", "", null);
    }

    public static StoreResult success(String name, String description, String display, Object data) {
        return new StoreResult(false, name, description, display, data);
    }

    public static StoreResult success() {
        return new StoreResult(false, "", "", "", null);
    }
}
