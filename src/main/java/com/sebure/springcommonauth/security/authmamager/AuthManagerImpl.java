package com.sebure.springcommonauth.security.authmamager;

import com.sebure.springcommonauth.code.UserType;
import com.sebure.springcommonauth.controller.dto.in.LoginInDto;
import com.sebure.springcommonauth.common.dto.TokenDto;
import com.sebure.springcommonauth.entity.AdminUser;
import com.sebure.springcommonauth.security.CustomUserAuthToken;
import com.sebure.springcommonauth.security.jwt.JwtProvider;
import com.sebure.springcommonauth.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
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

        CustomUserAuthToken customUserAuthToken = new CustomUserAuthToken(adminUser.getId(), adminUser.getUsername(), UserType.AdminUser);
        //Security에 권한 저장
        SecurityContextHolder.getContext().setAuthentication(customUserAuthToken);  // 사실 토큰 발급만 할꺼면 필요 없긴 하다.

        return jwtProvider.generateTokens(customUserAuthToken);
    }

    @Override
    public void checkRequestAuth(HttpServletRequest request) {
        String accessToken = jwtProvider.getAccessTokenFromRequest(request);
        if (!StringUtils.hasText(accessToken)) {
            throw new RuntimeException("accssToken이 없습니다.");
        }

        if (Boolean.FALSE.equals(jwtProvider.validateAccessToken(accessToken))) {
            throw new RuntimeException("accessToken 검증실패.");
        }

        log.info("accessToken 검사 통과...");
        Long userId = jwtProvider.getIdFromAccessToken(accessToken);
        log.info("userId : {}", userId);
        UserType userType = jwtProvider.getUserTypeFromAccessToken(accessToken);
        log.info("userType: {}", userType);
        String username = jwtProvider.getUserNameFromAccessToken(accessToken);
        log.info("username: {}", username);

        CustomUserAuthToken customUserAuthToken = new CustomUserAuthToken(userId, username, userType);
        customUserAuthToken.setAuthenticated(true);
        //Security에 권한 저장
        SecurityContextHolder.getContext().setAuthentication(customUserAuthToken);  // 사실 토큰 발급만 할꺼면 필요 없긴 하다.


    }

    @Override
    public CustomUserAuthToken getAuthentication() {
        return (CustomUserAuthToken) SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public AdminUser getAdminUserAuthentication() {
        CustomUserAuthToken customUserAuthToken = getAuthentication();
        if(Objects.nonNull(customUserAuthToken) &&
                UserType.AdminUser.equals(customUserAuthToken.getUserType())){
            return adminUserService.getAdminUserById(customUserAuthToken.getId());
        }
        return null;
    }


}
