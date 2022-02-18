package com.homeward.webstore.mapper;

import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.java.bean.BO.PlayerInfoBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlayerInfoMapper {
    PlayerInfoBO selectPlayer(String uuid);

    @JoinPointSymbol
    void insertPlayer(
            @Param("uuid") String uuid,
            @Param("name") String name,
            @Param("createTime") String createTime
    );
}
