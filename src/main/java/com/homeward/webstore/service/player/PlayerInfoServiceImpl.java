package com.homeward.webstore.service.player;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.common.enums.StatusEnum;
import com.homeward.webstore.common.utils.CommonUtil;
import com.homeward.webstore.mapper.PlayerInfoMapper;
import com.homeward.webstore.pojo.playerinfo.PlayerInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        if (StringUtils.isBlank(playerId)) {
            CommonUtil.throwRuntimeException(StatusEnum.ILLEGAL_CHAR);
        }

        String originMessage = this.getPlayerNameAndUUID(playerId);

        //名称是否可用
        if (StringUtils.isBlank(originMessage) || originMessage.contains("error")) {
            CommonUtil.throwRuntimeException(StatusEnum.PLAYER_NOT_FOUND);
        }

        JSONObject ObjectedMessage = JSONObject.parseObject(originMessage);

        String uuid = ObjectedMessage.getString("id");
        String name = ObjectedMessage.getString("name");
        String ProfileString = this.getPlayerProfile(uuid);

        JSONObject playerProfile = JSONObject.parseObject(ProfileString);

        // 查询数据库是否有数据, 没有则录入
        PlayerInfo playerInfo = this.selectPlayer(uuid);
        if (playerInfo == null) {
            this.insertPlayer(uuid, name);
        }

        return playerProfile;
    }


    /**
     * @param uuid
     * @return 玩家的基础信息
     * */
    @Override
    // @Cacheable(value = "SelectItemsInformation")
    public PlayerInfo selectPlayer(String uuid){
        return this.playerInfoMapper.selectPlayer(uuid);
    }


    /**
     * @param uuid
     * @param name
     */
    @Override
    @Transactional
    public void insertPlayer(String uuid, String name) {
        this.playerInfoMapper.insertPlayer(uuid, name);
    }


    /**
     * @param playerId
     * @return 玩家uuid与name(基础信息)
     */
    private String getPlayerNameAndUUID(String playerId) {
        String getInfo = String.format("https://api.mojang.com/users/profiles/minecraft/%s", playerId);
        return this.restTemplate.getForObject(getInfo, String.class);
    }


    /**
     * @param playerUUID
     * @return 玩家的详细信息
     */
    private String getPlayerProfile(String playerUUID) {
        String getProfile = String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", playerUUID);
        return this.restTemplate.getForObject(getProfile, String.class);
    }
}