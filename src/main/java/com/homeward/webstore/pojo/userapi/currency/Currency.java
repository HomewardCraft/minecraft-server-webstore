package com.homeward.webstore.pojo.userapi.currency;

import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Currency extends BasePojo {
    private Current current;
    private List<Options> options;
}
