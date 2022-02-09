package com.homeward.webstore.controller.player;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.service.interfaces.player.SelectPlayerInfoService;
import com.homeward.webstore.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController

public class PlayerInfoController {
    private final SelectPlayerInfoService playerInfo;
    public PlayerInfoController(SelectPlayerInfoService playerInfo) {
        this.playerInfo = playerInfo;
    }

    @GetMapping("/name/{id}")
    public JSONObject getPlayerInfo(@PathVariable("id") String playerId, ServerHttpRequest request, HttpServletResponse response) {
        CookieUtil.setCookie(response,"username",playerId,60);

        return playerInfo.getPlayerInfo(playerId);
    }
}
