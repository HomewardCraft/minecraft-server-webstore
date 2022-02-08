package com.homeward.webstore.controller.player;

import com.homeward.webstore.service.implement.player.SelectPlayerInfoService;
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
    public String getPlayerInfo(@PathVariable("id") String playerId) {
        return playerInfo.getPlayerInfo(playerId);
    }
}
