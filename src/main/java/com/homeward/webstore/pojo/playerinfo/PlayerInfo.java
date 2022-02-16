package com.homeward.webstore.pojo.playerinfo;

import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class PlayerInfo extends BasePojo {
    private String uuid;
    private String name;
}
