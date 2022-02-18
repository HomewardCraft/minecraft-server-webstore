package com.homeward.webstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.common.consts.SystemConst;
import com.homeward.webstore.common.utils.JwtUtil;
import com.homeward.webstore.java.bean.VO.R;
import com.homeward.webstore.service.player.PlayerInfoService;
import jakarta.servlet.http.HttpServletResponse;
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
    @JoinPointSymbol
    public R getPlayerInfo(@PathVariable("id") String playerId, HttpServletResponse response) {
        JSONObject playerProfile = playerInfo.getPlayerProfile(playerId);
        String uuid = playerProfile.getString("id");

        //使用jwt加密玩家uuid
        String playerUUIdEncrypted = JwtUtil.createToken(uuid);

        response.setHeader(SystemConst.SYSTEM_AUTHORIZATION_KEY.getName(),
                SystemConst.SYSTEM_AUTHORIZATION_HEAD.getName() + playerUUIdEncrypted
        );

        return R.ok(playerProfile);
    }
}
