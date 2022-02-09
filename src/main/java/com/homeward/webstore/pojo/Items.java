package com.homeward.webstore.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.homeward.webstore.pojo.Subset.Countdown;
import com.homeward.webstore.pojo.Subset.Price;
import lombok.Data;
import lombok.experimental.Accessors;

//此对象是商品类，最终要通过CrateResult返回
@Data
@Accessors(chain = true)
//想用mybatis plus就要与数据库表关联
@TableName("items")
public class Items {
    //商品id, 主键
    @TableId
    private Integer id;
    //商品名称
    private String name;
    //商品展示图片
    private String image;
    //打折, 不存在于数据库
    @TableField(exist = false)
    private Countdown countdown;
    //价格, 不存在于数据库
    @TableField(exist = false)
    private Price price;
    //是否在购物车
    private Boolean inCart;
    //商品类型, 不查询
    private String type;
}
