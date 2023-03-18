package com.sebure.springcommonauth.security;

import com.sebure.springcommonauth.controller.dto.in.LoginInDto;
import com.sebure.springcommonauth.common.dto.TokenDto;

public interface AuthManager {
    TokenDto loginAdminUser(LoginInDto loginInDto);
}
