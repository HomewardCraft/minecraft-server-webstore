package com.homeward.webstore.pojo.store;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Cart {

    private String uuid;
    private Integer id;
    private Integer quantity;

}
