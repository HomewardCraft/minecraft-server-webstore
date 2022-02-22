package com.homeward.webstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.common.consts.SystemConst;
import com.homeward.webstore.common.util.JwtUtils;
import com.homeward.webstore.java.bean.VO.R;
import com.homeward.webstore.service.PlayerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/name/{id}")
    @JoinPointSymbol
    public R getPlayerProfile(@PathVariable("id") String playerName, HttpServletResponse response) {
        JSONObject playerProfile = playerService.getPlayerProfile(playerName);
        String uuid = playerProfile.getString("id");

        if (!JwtUtils.verity()) {
            String playerEncryptedUUId = JwtUtils.createToken(uuid);
            response.setHeader(SystemConst.AUTHORIZATION_NAME.getInformation(),
                    SystemConst.AUTHORIZATION_PREFIX.getInformation() + playerEncryptedUUId
            );
        }

        return R.ok(playerProfile.toJavaObject(Object.class));
    }
}
