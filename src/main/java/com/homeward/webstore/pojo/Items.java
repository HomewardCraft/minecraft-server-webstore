package com.homeward.webstore.pojo;

import com.homeward.webstore.pojo.Subset.Countdown;
import com.homeward.webstore.pojo.Subset.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//此对象是商品类，最终要通过CrateResult返回
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    //商品id
    private Integer id;
    //商品名称
    private String name;
    //商品展示图片
    private String image;
    //打折
    private Countdown countdown;
    //价格
    private Price price;
    //是否在购物车
    private Boolean inCart;

}
