package com.homeward.webstore.pojo.packages;

import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class ItemsList extends BasePojo {
    private Integer id;
    private String name;
    private String image;
    private Integer price;
    //不存在
    private OnSale onSale;
}
