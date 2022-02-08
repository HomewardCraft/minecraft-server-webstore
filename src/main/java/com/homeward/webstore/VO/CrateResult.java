package com.homeward.webstore.VO;


import com.homeward.webstore.pojo.Items;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

//此对象为传给前端的最终json集
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class CrateResult {
    //是否错误
    private Boolean isError;
    //分类名称
    private String name;
    //分类描述
    private String description;
    //分类展示方法
    private String display;
    //商品包含的中分类
    private List<Items> packages;
}
