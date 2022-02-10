package com.homeward.webstore.pojo.userapi.cart;

import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Cart extends BasePojo {
    private List<Items> items;
    private Float total;
}
