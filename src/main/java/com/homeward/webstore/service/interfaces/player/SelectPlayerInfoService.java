package com.homeward.webstore.service.interfaces.player;

public interface SelectPlayerInfoService {
    String getPlayerUUID(String playerId);
    String getPlayerInfo(String playerUUID);
}
