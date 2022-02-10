package com.homeward.webstore.pojo.userapi.categories;

import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class Categories extends BasePojo {
    private String id;
    private String name;
}
