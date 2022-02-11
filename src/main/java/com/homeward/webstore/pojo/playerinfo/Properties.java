package com.homeward.webstore.pojo.playerinfo;

import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Properties extends BasePojo {
    private String id;
    private String name;
    private String value;
    private String signature;
}
