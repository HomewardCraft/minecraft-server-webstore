package com.homeward.webstore.service.implement.player;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.service.interfaces.player.SelectPlayerInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SelectPlayerInfoServiceImpl implements SelectPlayerInfoService {

    private final RestTemplate restTemplate;

    public SelectPlayerInfoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public JSONObject getPlayerInfo(String playerId) {
        /*获取player的uuid*/
        JSONObject MessageObject = this.getAPIMessage(playerId);
        /*判断是否有效*/
        if (MessageObject.getString("error") != null || MessageObject.isEmpty()) {
            return MessageObject;
        }
        /*获取玩家uuid*/
        String playerName = MessageObject.getString("id");
        String fullURL = String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s", playerName);
        String MojangAPIMessage = restTemplate.getForObject(fullURL, String.class);
        return JSON.parseObject(MojangAPIMessage);
    }

    //what it is ?
    //get player uuid
    @Override
    public JSONObject getAPIMessage(String playerId) {
        String fullURL = String.format("https://api.mojang.com/users/profiles/minecraft/%s", playerId);
        String MojangAPIMessage = restTemplate.getForObject(fullURL, String.class);
        return JSON.parseObject(MojangAPIMessage);
    }
}
