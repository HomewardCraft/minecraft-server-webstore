package com.homeward.webstore.service.player;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.java.bean.BO.PlayerInfoBO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public interface PlayerInfoService {
    JSONObject getPlayerProfile(String playerUUID, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response);
    void insertPlayer(String id, String playerName);
    PlayerInfoBO selectPlayer(String id);
}
