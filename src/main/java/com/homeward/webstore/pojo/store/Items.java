package com.homeward.webstore.pojo.store;

import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Items extends BasePojo {
    private Integer id;
    private String name;
    private String image;
    //不存在
    private Countdown countdown;
    //不存在
    private Price price;
    private Boolean inCart;
}
