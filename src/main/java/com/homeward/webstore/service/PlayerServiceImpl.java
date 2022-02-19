package com.homeward.webstore.service;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.common.enums.DateEnum;
import com.homeward.webstore.common.enums.StatusEnum;
import com.homeward.webstore.common.util.CommonUtils;
import com.homeward.webstore.java.bean.BO.PlayerInfoBO;
import com.homeward.webstore.mapper.PlayerMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


@Service
public class PlayerServiceImpl implements PlayerService {

    private final RestTemplate restTemplate;
    private final PlayerMapper playerMapper;

    public PlayerServiceImpl(RestTemplate restTemplate, PlayerMapper playerMapper) {
        this.restTemplate = restTemplate;
        this.playerMapper = playerMapper;
    }


    /**
     * 返回玩家的详细信息, 如果玩家不存在于表中, 将添加
     * @param playerId
     * @return 玩家的profile
     */
    @Override
    @JoinPointSymbol
    public JSONObject getPlayerProfile(String playerId) {
        if (StringUtils.isBlank(playerId)) {
            CommonUtils.throwRuntimeException(StatusEnum.ILLEGAL_CHAR);
        }

        String originMessage = this.getPlayerBasicInfo(playerId);

        //名称是否可用
        if (StringUtils.isBlank(originMessage) || originMessage.contains("error")) {
            CommonUtils.throwRuntimeException(StatusEnum.PLAYER_NOT_FOUND);
        }

        JSONObject ObjectedMessage = JSONObject.parseObject(originMessage);

        String uuid = ObjectedMessage.getString("id");
        String name = ObjectedMessage.getString("name");
        String ProfileString = this.getPlayerDetails(uuid);

        JSONObject playerProfile = JSONObject.parseObject(ProfileString);

        // 查询数据库是否有数据, 没有则录入
        PlayerInfoBO playerInfoBO = this.selectPlayer(uuid);
        if (playerInfoBO == null) {
            this.insertPlayer(uuid, name);
        }

        return playerProfile;
    }


    /**
     * @param uuid
     * @return 玩家的uuid与name
     * */
    @Override
    public PlayerInfoBO selectPlayer(String uuid){
        return this.playerMapper.selectPlayer(uuid);
    }


    /**
     * @param uuid
     * @param name
     */
    @Override
    @Transactional
    public void insertPlayer(String uuid, String name) {
        String createTime = CommonUtils.currentFormattedDate(DateEnum.yyyyMMddHHmmss);
        Long rowAffected = this.playerMapper.insertPlayer(uuid, name, createTime);
        if (rowAffected == 0) {
            CommonUtils.throwRuntimeException(StatusEnum.DATABASE_ERROR);
        }
    }


    /**
     * @param playerId
     * @return 玩家uuid与name(从mojang)
     */
    private String getPlayerBasicInfo(String playerId) {
        String getInfo = String.format("https://api.mojang.com/users/profiles/minecraft/%s", playerId);
        return this.restTemplate.getForObject(getInfo, String.class);
    }


    /**
     * @param playerUUID
     * @return 玩家的profile
     */
    private String getPlayerDetails(String playerUUID) {
        String getProfile = String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", playerUUID);
        return this.restTemplate.getForObject(getProfile, String.class);
    }
}