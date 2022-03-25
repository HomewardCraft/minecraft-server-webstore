package com.homeward.webstore.java.bean.BO;

import com.homeward.webstore.java.bean.PO.BasicPersistentObject;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemName implements BasicPersistentObject, Cloneable {
    Integer id;
    Integer amount;
    String name;
    String descriptionId;

    @Override
    public ItemName clone() {
        try {
            return (ItemName) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
