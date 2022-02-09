package com.homeward.webstore.controller.player;

import com.homeward.webstore.service.interfaces.player.SelectPlayerInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
