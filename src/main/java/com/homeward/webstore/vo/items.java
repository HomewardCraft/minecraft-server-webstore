package com.homeward.webstore.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class items {

    private Integer id;
    private String name;
    private Boolean discount;
    private Integer quantity;

}
