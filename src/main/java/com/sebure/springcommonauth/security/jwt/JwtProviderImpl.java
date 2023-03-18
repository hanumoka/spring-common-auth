package com.sebure.springcommonauth.security.jwt;

import com.sebure.springcommonauth.common.dto.TokenDto;
import com.sebure.springcommonauth.entity.AdminUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtProviderImpl implements JwtProvider{
    @Override
    public TokenDto createAdminUserTokens(AdminUser adminUser) {
        return null;
    }

    private String generateAccessTokenForAdminUser(){
        //TODO: 작업중
    }

    private String generateToken(UserDetails userDetails, String secretKey, Long expirationSeconds){
        return "";
    }
}
