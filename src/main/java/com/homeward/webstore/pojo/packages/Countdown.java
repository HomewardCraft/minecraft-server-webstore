package com.homeward.webstore.pojo.packages;

import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Countdown extends BasePojo {
    private Integer id;
    private Boolean isActive;
    private Integer time;
}
