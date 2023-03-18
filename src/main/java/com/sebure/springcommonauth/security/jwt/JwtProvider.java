package com.sebure.springcommonauth.security.jwt;

import com.sebure.springcommonauth.common.dto.TokenDto;
import com.sebure.springcommonauth.entity.AdminUser;

public interface JwtProvider {
    TokenDto createAdminUserTokens(AdminUser adminUser);
}
