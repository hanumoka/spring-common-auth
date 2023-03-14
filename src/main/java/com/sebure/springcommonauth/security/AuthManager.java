package com.sebure.springcommonauth.security;

import com.sebure.springcommonauth.controller.dto.in.LoginInDto;
import com.sebure.springcommonauth.controller.dto.out.TokenOutDto;

public interface AuthManager {
    TokenOutDto loginAdminUser(LoginInDto loginInDto);
}
