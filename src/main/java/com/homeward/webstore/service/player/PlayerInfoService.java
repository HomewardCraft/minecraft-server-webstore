package com.homeward.webstore.service.player;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public interface PlayerInfoService {
    String getPlayerInformation(String playerId);
    JSONObject getPlayerProfile(String playerUUID, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response);
}
