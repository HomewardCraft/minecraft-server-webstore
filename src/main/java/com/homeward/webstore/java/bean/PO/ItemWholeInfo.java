package com.homeward.webstore.java.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemWholeInfo implements BasicPersistentObject{
    private Integer id;
    private String name;
    private String imageAddress;
    private String type;
    private String price;
    private Boolean saleCondition;
    private Integer salePercent;
}
