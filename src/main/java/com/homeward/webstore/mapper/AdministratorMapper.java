package com.homeward.webstore.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdministratorMapper {
    Long AdministratorLogin(@Param("adminName") String adminName, @Param("adminPwd") String adminPwd);
}
