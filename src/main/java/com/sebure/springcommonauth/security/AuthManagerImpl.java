package com.sebure.springcommonauth.security;

import com.sebure.springcommonauth.controller.dto.in.LoginInDto;
import com.sebure.springcommonauth.controller.dto.out.TokenOutDto;
import com.sebure.springcommonauth.entity.AdminUser;
import com.sebure.springcommonauth.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthManagerImpl implements AuthManager {

    private final AdminUserService adminUserService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public TokenOutDto loginAdminUser(LoginInDto loginInDto) {

        AdminUser adminUser = adminUserService.getAdminUserByUsername(loginInDto.getUsername());

        if (Objects.nonNull(adminUser)
                && adminUser.checkMemberValidity()
                && adminUser.checkPassword(loginInDto.getPassword(), passwordEncoder)) {

        }


        return null;
    }
}
