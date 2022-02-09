package com.homeward.webstore.pojo.Subset;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

//此对象是计时类，最终要封装至Items
@Data
@Accessors(chain = true)
//详情见Items
@TableName("count_down")
public class Countdown {
    @TableId
    private Integer id;
    private Boolean isActive;
    private Integer time;
}
