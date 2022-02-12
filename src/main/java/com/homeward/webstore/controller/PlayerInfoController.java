package com.homeward.webstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.service.player.PlayerInfoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlayerInfoController {
    private final PlayerInfoService playerInfo;
    public PlayerInfoController(PlayerInfoService playerInfo) {
        this.playerInfo = playerInfo;
    }

    @GetMapping("/name/{id}")
    public JSONObject getPlayerInfo(@PathVariable("id") String playerId, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        return this.playerInfo.getPlayerProfile(playerId, httpSession, request, response);
    }
}
