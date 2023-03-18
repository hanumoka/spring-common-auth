package com.sebure.springcommonauth.security;

import com.sebure.springcommonauth.controller.dto.in.LoginInDto;
import com.sebure.springcommonauth.common.dto.TokenDto;
import com.sebure.springcommonauth.entity.AdminUser;
import com.sebure.springcommonauth.security.jwt.JwtProvider;
import com.sebure.springcommonauth.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
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
    private final JwtProvider jwtProvider;

    @Transactional
    @Override
    public TokenDto loginAdminUser(LoginInDto loginInDto) {

        AdminUser adminUser = adminUserService.getAdminUserByUsername(loginInDto.getUsername());

        if (Objects.isNull(adminUser)
                || !adminUser.checkMemberValidity()
                || !adminUser.checkPassword(loginInDto.getPassword(), passwordEncoder)) {
            throw new BadCredentialsException(null);
        }



        return null;
    }
}
