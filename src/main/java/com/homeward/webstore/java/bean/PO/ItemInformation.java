package com.homeward.webstore.java.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemInformation implements BasicPersistentObject{
    private String type;
}
