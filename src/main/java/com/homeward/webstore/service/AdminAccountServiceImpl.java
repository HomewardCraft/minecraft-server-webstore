package com.homeward.webstore.service;

import com.homeward.webstore.common.enums.AdministratorStatusEnum;
import com.homeward.webstore.common.util.CommonUtils;
import com.homeward.webstore.java.bean.VO.AdminInfo;
import com.homeward.webstore.mapper.AdminAccountMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminAccountServiceImpl implements AdminAccountService{
    private final AdminAccountMapper adminAccountMapper;

    public AdminAccountServiceImpl(AdminAccountMapper adminAccountMapper) {
        this.adminAccountMapper = adminAccountMapper;
    }

    @Override
    public String administratorLogin(AdminInfo adminInfo) {
        String username = String.valueOf(adminInfo.getUsername());
        String password = String.valueOf(adminInfo.getPassword());

        if (username.equals("null") || password.equals("null")) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.LOGIN_INFORMATION_ERROR);
        }

        Long rowSelected = adminAccountMapper.AdministratorLogin(username, password);

        if (rowSelected != 1) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.ADMINISTRATOR_INFORMATION_ERROR);
        }

        return username;
    }
}
