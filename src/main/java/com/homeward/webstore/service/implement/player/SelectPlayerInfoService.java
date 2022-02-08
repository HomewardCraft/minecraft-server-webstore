package com.homeward.webstore.service.implement.player;

public interface SelectPlayerInfoService {
    String getPlayerUUID(String playerId);
    String getPlayerInfo(String playerUUID);
}
