package com.homeward.webstore.service;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.java.bean.BO.PlayerInfoBO;

public interface PlayerService {
    @JoinPointSymbol
    JSONObject getPlayerProfile(String playerUUID);

    void insertPlayer(String id, String playerName);

    PlayerInfoBO selectPlayer(String id);
}
