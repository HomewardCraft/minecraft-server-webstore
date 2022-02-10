package com.homeward.webstore.pojo.userapi.cart;


import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Items extends BasePojo {
    private Integer id;
    private String name;
    private Boolean discount;
    private Float price;
    private Integer quantity;
}
