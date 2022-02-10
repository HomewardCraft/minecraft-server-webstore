package com.homeward.webstore.pojo.userapi.currency;

import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Options extends BasePojo {
    private String code;
    private String symbol;
}
