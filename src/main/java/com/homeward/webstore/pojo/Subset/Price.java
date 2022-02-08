package com.homeward.webstore.pojo.Subset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//此对象是价格类，最终要封装至Items
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    private String type;
    private Float discount;
    private Float sale;
}
