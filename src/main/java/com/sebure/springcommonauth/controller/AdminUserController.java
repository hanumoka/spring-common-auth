package com.sebure.springcommonauth.controller;

import com.sebure.springcommonauth.controller.dto.in.LoginInDto;
import com.sebure.springcommonauth.common.dto.TokenDto;
import com.sebure.springcommonauth.entity.AdminUser;
import com.sebure.springcommonauth.security.CustomUserAuthToken;
import com.sebure.springcommonauth.security.authmamager.AuthManager;
import com.sebure.springcommonauth.service.AdminUserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin-users")
public class AdminUserController {

    private final AuthManager authManager;

    @PostMapping("/_login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginInDto loginInDto) {
        return ResponseEntity.ok(authManager.loginAdminUser(loginInDto));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/_me")
    public ResponseEntity<AdminUser> getMe(){
        log.info("get me...");
        AdminUser adminUser = authManager.getAdminUserAuthentication();
        return ResponseEntity.ok(adminUser);
    }

}
