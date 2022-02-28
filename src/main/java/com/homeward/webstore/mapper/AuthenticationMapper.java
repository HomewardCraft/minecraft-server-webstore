package com.homeward.webstore.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用于interceptor认证的mapper类
 * 不应该出现在business中
 */
@Mapper
public interface AuthenticationMapper {

    /**
     * 查询拥有该uuid与item id的用户，在数据库中的cart有几份
     * @param uuid String
     * @param itemId Integer
     * @return item id
     */
    List<Integer> itemIdList(
            @Param("uuid") String uuid,
            @Param("itemId") Integer itemId
    );
}
