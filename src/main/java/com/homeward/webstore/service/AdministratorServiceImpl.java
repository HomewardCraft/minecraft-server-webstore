package com.homeward.webstore.service;

import com.homeward.webstore.common.enums.AdministratorStatusEnum;
import com.homeward.webstore.common.util.CommonUtils;
import com.homeward.webstore.mapper.AdministratorMapper;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AdministratorServiceImpl implements AdministratorService{
    private final AdministratorMapper administratorMapper;

    public AdministratorServiceImpl(AdministratorMapper administratorMapper) {
        this.administratorMapper = administratorMapper;
    }

    @Override
    public String administratorLogin(Map<String, String> adminInfo) {
        AtomicReference<String> atomicUsername = new AtomicReference<>(null);
        AtomicReference<String> atomicPassword = new AtomicReference<>(null);

        adminInfo.forEach((key, value) -> {
            if (key.contains("username")) {
                atomicUsername.set(value);
            }
            if (key.contains("password")) {
                atomicPassword.set(value);
            }
        });

        String username = String.valueOf(atomicUsername);
        String password = String.valueOf(atomicPassword);

        if (username.equals("null") || password.equals("null")) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.LOGIN_INFORMATION_ERROR);
        }

        Long rowSelected = administratorMapper.AdministratorLogin(username, password);

        if (rowSelected != 1) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.ADMINISTRATOR_INFORMATION_ERROR);
        }

        return username;
    }
}
