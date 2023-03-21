package com.sebure.springcommonauth.security.jwt;

import com.sebure.springcommonauth.code.UserType;
import com.sebure.springcommonauth.common.dto.TokenDto;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {

    TokenDto generateTokens(Authentication authentication);

    String getAccessTokenFromRequest(HttpServletRequest request);

    boolean validateAccessToken(String accessToken);

    Long getIdFromAccessToken(String accessToken);
    UserType getUserTypeFromAccessToken(String accessToken);
    String getUserNameFromAccessToken(String accessToken);
}
