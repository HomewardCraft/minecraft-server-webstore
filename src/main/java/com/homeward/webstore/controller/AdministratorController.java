package com.homeward.webstore.controller;

import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.common.consts.SystemConst;
import com.homeward.webstore.common.util.JwtUtils;
import com.homeward.webstore.java.bean.VO.R;
import com.homeward.webstore.service.AdministratorService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AdministratorController {
    private final AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }


    @PostMapping("/admin/login")
    @JoinPointSymbol
    public R administratorLogin(@RequestParam Map<String, String> adminInfo, HttpServletResponse response) {
        if (!JwtUtils.verity()) {
            String username = administratorService.administratorLogin(adminInfo);
            String administratorEncryptedUsername = JwtUtils.createToken(username);
            response.setHeader(SystemConst.AUTHORIZATION_NAME.getInformation(),
                    SystemConst.AUTHORIZATION_PREFIX.getInformation() + administratorEncryptedUsername
            );
        }
        return R.ok();
    }
}
