package com.sebure.springcommonauth.security.jwt;

import com.sebure.springcommonauth.common.dto.TokenDto;
import org.springframework.security.core.Authentication;

public interface JwtProvider {

    TokenDto generateTokens(Authentication authentication);
}
