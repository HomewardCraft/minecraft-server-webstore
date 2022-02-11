package com.homeward.webstore.mapper;

import com.homeward.webstore.pojo.playerinfo.PlayerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlayerInfoMapper {
    PlayerInfo getPlayerInfo(String playerName);

    void addPlayer(
            @Param("id") String id, @Param("playerName") String playerName,
            @Param("propertyName") String propertyName, @Param("value") String value,
            @Param("signature") String signature, @Param("legacy") Boolean legacy
    );
}
