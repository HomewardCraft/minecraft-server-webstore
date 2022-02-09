package com.homeward.webstore.pojo.Subset;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

//此对象是价格类，最终要封装至Items
@Data
@Accessors(chain = true)
//详情见Items
@TableName("price")
public class Price {
    @TableId
    private Integer id;
    private String type;
    private Float discount;
    private Float sale;
}
