package com.homeward.webstore.pojo.packages;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("count_down")
public class Countdown extends BasePojo {
    @TableId
    private Integer id;
    private Boolean isActive;
    private Integer time;
}
