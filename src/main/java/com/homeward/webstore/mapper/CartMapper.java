package com.homeward.webstore.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface CartMapper {
    long insertCart(
            @Param("uuid") String uuid,
            @Param("itemId") Integer itemId,
            @Param("amount") Integer amount
    );

    long updateCart(
            @Param("uuid") String uuid,
            @Param("itemId") Integer itemId,
            @Param("amount") Integer amount
    );

    long deleteCart(
            @Param("uuid") String uuid,
            @Param("itemId") Integer itemId
    );

    Float getTotalPrice(String uuid);

    long initializeCart();
}
