package com.sebure.springcommonauth.security;

import com.sebure.springcommonauth.controller.dto.in.LoginInDto;
import com.sebure.springcommonauth.controller.dto.out.TokenOutDto;
import org.springframework.stereotype.Service;

@Service
public class AuthManagerImpl implements AuthManager {

    @Override
    public TokenOutDto loginAdminUser(LoginInDto loginInDto) {
        return null;
    }
}
