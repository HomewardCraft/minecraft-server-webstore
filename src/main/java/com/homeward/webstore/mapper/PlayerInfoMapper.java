package com.homeward.webstore.mapper;

import com.homeward.webstore.pojo.playerinfo.PlayerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlayerInfoMapper {
    PlayerInfo getPlayerInfo(String playerName);

    void addPlayer(
            @Param("uuid") String uuid,
            @Param("name") String name,
            @Param("legacy") Boolean legacy
    );
}
