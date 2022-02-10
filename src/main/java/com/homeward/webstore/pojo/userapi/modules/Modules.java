package com.homeward.webstore.pojo.userapi.modules;

import com.homeward.webstore.pojo.BasePojo;
import com.homeward.webstore.pojo.userapi.modules.empty.Empty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Modules extends BasePojo {
    private Float dollar;
    private Empty empty;
}
