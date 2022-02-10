package com.homeward.webstore.pojo.userapi.currency;

import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Current extends BasePojo {
    private String code;
    private String symbol;
}
