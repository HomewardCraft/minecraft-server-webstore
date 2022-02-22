package com.homeward.webstore.java.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemBasicInfo implements BasicPersistentObject{
    private Integer id;
    private String name;
    private String imageAddress;
    private Integer price;
}
