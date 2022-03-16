package com.homeward.webstore.java.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemShowCaseInfo implements BasicPersistentObject{
    private Integer id;
    private String name;
    private Integer price;
    private Boolean saleCondition;
    private Integer salePercent;
    private String imageAddress;
    private String imageHoverAddress;
}
