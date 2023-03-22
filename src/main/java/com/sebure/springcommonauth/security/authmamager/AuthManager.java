package com.sebure.springcommonauth.security.authmamager;

import com.sebure.springcommonauth.controller.dto.in.LoginInDto;
import com.sebure.springcommonauth.common.dto.TokenDto;
import com.sebure.springcommonauth.entity.AdminUser;
import com.sebure.springcommonauth.entity.MemberUser;
import com.sebure.springcommonauth.security.CustomUserAuthToken;

import javax.servlet.http.HttpServletRequest;

public interface AuthManager {
    TokenDto loginAdminUser(LoginInDto loginInDto);

    void checkRequestAuth(HttpServletRequest request);

    CustomUserAuthToken getAuthentication();

    AdminUser getAdminUserAuthentication();

}
