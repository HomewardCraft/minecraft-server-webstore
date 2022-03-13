package com.homeward.webstore.controller;

import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.common.consts.SystemConst;
import com.homeward.webstore.common.util.JwtUtils;
import com.homeward.webstore.java.bean.VO.AdminInfo;
import com.homeward.webstore.java.bean.VO.R;
import com.homeward.webstore.service.AdminAccountService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminAccountController {
    private final AdminAccountService adminAccountService;

    public AdminAccountController(AdminAccountService adminAccountService) {
        this.adminAccountService = adminAccountService;
    }


    @PostMapping("/login")
    @JoinPointSymbol
    public R administratorLogin(@RequestBody AdminInfo adminInfo, HttpServletResponse response) {
        if (!JwtUtils.verity()) {
            String username = adminAccountService.administratorLogin(adminInfo);
            String administratorEncryptedUsername = JwtUtils.createToken(username);
            response.setHeader(SystemConst.AUTHORIZATION_NAME.getInformation(),
                    SystemConst.AUTHORIZATION_PREFIX.getInformation() + administratorEncryptedUsername
            );
        }
        return R.ok();
    }
}
