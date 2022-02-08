package com.homeward.webstore.service;

import com.homeward.webstore.VO.PlayerInfoResult;

public interface SelectPlayerInfoService {
    String getPlayerUUID(String playerId);
    String getPlayerInfo(String playerUUID);
}
