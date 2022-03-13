package com.homeward.webstore.java.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemWholeInfo implements BasicPersistentObject{
    private Integer id;
    private String type;
    private String name;
    private String price;
    private Boolean saleCondition;
    private Integer salePercent;
    private String imageAddress;
    private String imageHoverAddress;
//   todo 描述
}

// 名字 图片地址 类型 价格 打折 打折比 描述