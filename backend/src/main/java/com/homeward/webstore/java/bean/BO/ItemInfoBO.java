package com.homeward.webstore.java.bean.BO;

import com.homeward.webstore.java.bean.PO.ItemBasicInfo;
import com.homeward.webstore.java.bean.PO.ItemSaleInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ItemInfoBO implements Serializable {
    private ItemBasicInfo itemBasicInfo;
    private ItemSaleInfo itemSaleInfo;
}
