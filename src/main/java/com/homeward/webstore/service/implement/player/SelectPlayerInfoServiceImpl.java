package com.homeward.webstore.service.implement.player;

import com.homeward.webstore.service.interfaces.player.SelectPlayerInfoService;
import com.homeward.webstore.util.JsonMap;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class SelectPlayerInfoServiceImpl implements SelectPlayerInfoService {

    private final RestTemplate restTemplate;
    private final JsonMap jsonMap;

    public SelectPlayerInfoServiceImpl(RestTemplate restTemplate, JsonMap jsonMap) {
        this.restTemplate = restTemplate;
        this.jsonMap = jsonMap;
    }

    @Override
    public String getPlayerInfo(String playerId) {
        String playerNameAndUUID = this.getPlayerUUID(playerId);
        Map<String, String> jsonMap = this.jsonMap.getJsonMap(playerNameAndUUID);
        String playerUUID = jsonMap.get("id");
        //use player uuid to get player profile
        String fullURL = String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s", playerUUID);
        return restTemplate.getForObject(fullURL, String.class);
    }
    //what it is ?
    //get player uuid
    @Override
    public String getPlayerUUID(String playerId) {
        String fullURL = String.format("https://api.mojang.com/users/profiles/minecraft/%s", playerId);
        return restTemplate.getForObject(fullURL, String.class);
    }
}
