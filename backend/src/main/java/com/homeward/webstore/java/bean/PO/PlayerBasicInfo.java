package com.homeward.webstore.java.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PlayerBasicInfo implements BasicPersistentObject{
    private String name;
    private String uuid;
}
