package com.homeward.webstore.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthenticationMapper {
    List<Integer> isSingleCart(
            @Param("uuid") String uuid
    );
}
