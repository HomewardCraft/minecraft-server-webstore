package com.homeward.webstore.service.player;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.mapper.PlayerInfoMapper;
import com.homeward.webstore.pojo.playerinfo.PlayerInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlayerInfoServiceImpl implements PlayerInfoService {

    private final RestTemplate restTemplate;
    private final PlayerInfoMapper playerInfoMapper;

    public PlayerInfoServiceImpl(RestTemplate restTemplate, PlayerInfoMapper playerInfoMapper) {
        this.restTemplate = restTemplate;
        this.playerInfoMapper = playerInfoMapper;
    }

    @Override
    public JSONObject getPlayerProfile(String playerId, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        //创建cookie
        Cookie cookie = new Cookie("HOMEWARD_USER_INFO", playerId);

        //设置参数
        cookie.setMaxAge(2592000);

        //设置路径, get context path为空不能用
        cookie.setPath("/");

        //先从数据库找
        PlayerInfo playerInfo = playerInfoMapper.getPlayerInfo(playerId);
        if (playerInfo != null) {
            String playerInfoString = JSONObject.toJSONString(playerInfo);

            //传输cookie
            response.addCookie(cookie);

            return JSONObject.parseObject(playerInfoString);
        }

        //返回玩家uuid
        String OriginMessage = this.getPlayerInformation(playerId);

        //名称不可用返回, 这个顺序判断不会npe
        if (OriginMessage == null || OriginMessage.equals("") || OriginMessage.contains("error")) {
            OriginMessage = "{\"error\":true}";
            return JSONObject.parseObject(OriginMessage);
        }

        //转成java对象
        JSONObject ObjectedMessage = JSONObject.parseObject(OriginMessage);

        //获取玩家profile
        String UUID = ObjectedMessage.getString("id");
        String getProfile = String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", UUID);
        String ProfileString = restTemplate.getForObject(getProfile, String.class);

        //转对象
        JSONObject playerProfile = JSONObject.parseObject(ProfileString);

        //获取properties的数组
        JSONArray propertyArray = playerProfile.getJSONArray("properties");

        //格式化string
        String propertyString = propertyArray.toJSONString();
        String formattedProperty = propertyString.replaceAll("[\\[\\]]", "");

        //转对象
        JSONObject propertyObject = JSONObject.parseObject(formattedProperty);

        //获取值
        String id = playerProfile.getString("id");
        String playerName = playerProfile.getString("name");
        String propertyName = propertyObject.getString("name");
        String value = propertyObject.getString("value");
        String signature = propertyObject.getString("signature");
        Boolean legacy = playerProfile.getBoolean("legacy");

        playerInfoMapper.addPlayer(id, playerName, propertyName, value, signature, legacy);
        response.addCookie(cookie);

        return playerProfile;
    }


    @Override
    public String getPlayerInformation(String playerId) {
        String getInfo = String.format("https://api.mojang.com/users/profiles/minecraft/%s", playerId);
        return restTemplate.getForObject(getInfo, String.class);
    }
}