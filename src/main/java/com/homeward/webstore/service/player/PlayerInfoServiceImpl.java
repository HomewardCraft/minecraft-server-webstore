package com.homeward.webstore.service.player;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.aop.annotations.JoinPointSymbol;
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


    /**
     * add player to database (if player haven't signed up)
     * and return player json formatted profile
     * @param playerId player string name
     * @return player profile information
     */
    @Override
    @JoinPointSymbol
    public JSONObject getPlayerProfile(String playerId, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        //创建cookie
        Cookie cookie = new Cookie("HOMEWARD_USER_INFO", playerId);

        //设置参数
        cookie.setMaxAge(2592000);

        //设置路径, get context path为空不能用
        cookie.setPath("/");

        //返回玩家uuid和名字
        String OriginMessage = this.getPlayerInformation(playerId);

        //名称不可用返回, 这个顺序判断不会npe
        if (OriginMessage == null || OriginMessage.equals("") || OriginMessage.contains("error")) {
            OriginMessage = "{\"error\":true}";
            return JSONObject.parseObject(OriginMessage);
        }

        //转成java对象方便oop
        JSONObject ObjectedMessage = JSONObject.parseObject(OriginMessage);

        //截取玩家uuid, 获取玩家profile
        String UUID = ObjectedMessage.getString("id");
        String ProfileString = this.getPlayerProfile(UUID);

        //转成json对象方便oop
        JSONObject playerProfile = JSONObject.parseObject(ProfileString);

        //获取值
        String uuid = playerProfile.getString("id");
        String name = playerProfile.getString("name");
        Boolean legacy = playerProfile.getBoolean("legacy");

        //查询数据库是否有数据, 没有则录入
        PlayerInfo playerInfo = this.playerInfoMapper.getPlayerInfo(playerId);
        if (playerInfo == null) {
            this.addPlayer(uuid, name, legacy);
        }

        //返回一个cookie
        response.addCookie(cookie);

        return playerProfile;
    }


    /**
     * @param playerId the player string name
     * @return player json formatted name and UUID
     */
    private String getPlayerInformation(String playerId) {
        String getInfo = String.format("https://api.mojang.com/users/profiles/minecraft/%s", playerId);
        return this.restTemplate.getForObject(getInfo, String.class);
    }


    /**
     * @param playerUUID the player uuid
     * @return player json formatted profile information
     */
    private String getPlayerProfile(String playerUUID) {
        String getProfile = String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", playerUUID);
        return this.restTemplate.getForObject(getProfile, String.class);
    }


    /**
     * @param uuid           player uuid
     * @param name   player string name
     * @param legacy       player profile whether legacy
     */
    @Override
    @JoinPointSymbol
    public void addPlayer(String uuid, String name, Boolean legacy) {
        this.playerInfoMapper.addPlayer(uuid, name, legacy);
    }
}