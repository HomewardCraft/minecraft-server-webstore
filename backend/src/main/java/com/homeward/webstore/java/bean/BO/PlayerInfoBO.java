package com.homeward.webstore.java.bean.BO;

import com.homeward.webstore.java.bean.PO.PlayerBasicInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PlayerInfoBO implements Serializable {
    PlayerBasicInfo playerBasicInfo;
}
