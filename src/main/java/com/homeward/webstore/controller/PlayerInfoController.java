package com.homeward.webstore.controller;

import com.homeward.webstore.service.SelectPlayerInfoService;
import com.homeward.webstore.util.JsonResult;
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
    public JsonResult<String> getPlayerInfo(@PathVariable("id") String playerId) {
        return JsonResult.build().code(JsonResult.SUCCESS).data(playerInfo.getPlayerInfo(playerId));
    }
}
