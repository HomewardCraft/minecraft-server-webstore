package com.homeward.webstore.pojo.packages;

import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Price extends BasePojo {
    private Integer id;
    private String type;
    private Float discount;
    private Float sale;
}
