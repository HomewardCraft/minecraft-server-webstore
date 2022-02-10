package com.homeward.webstore.service.implement.player;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.service.interfaces.player.PlayerInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlayerInfoServiceImpl implements PlayerInfoService {

    private final RestTemplate restTemplate;

    public PlayerInfoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public JSONObject getPlayerInfo(String playerId) {
        JSONObject MessageObject = this.getAPIMessage(playerId);

        if (MessageObject.getString("error") != null || MessageObject.isEmpty()) {
            return MessageObject;
        }

        //查库 精确
        //无? 录库

        //给cookie

        String playerName = MessageObject.getString("id");
        String fullURL = String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s", playerName);
        String MojangAPIMessage = restTemplate.getForObject(fullURL, String.class);

        return JSON.parseObject(MojangAPIMessage);
    }

    @Override
    public JSONObject getAPIMessage(String playerId) {
        String fullURL = String.format("https://api.mojang.com/users/profiles/minecraft/%s", playerId);
        String MojangAPIMessage = restTemplate.getForObject(fullURL, String.class);

        return JSON.parseObject(MojangAPIMessage);
    }
}
