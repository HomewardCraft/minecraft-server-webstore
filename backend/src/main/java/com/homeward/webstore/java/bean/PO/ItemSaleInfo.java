package com.homeward.webstore.java.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemSaleInfo implements BasicPersistentObject{
    private Boolean onsaleCondition;
    private Integer surplusTime;
    private Integer onsalePercent;
}