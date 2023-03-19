package com.sebure.springcommonauth.security;

import com.sebure.springcommonauth.code.UserType;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * jwt 엑세스토큰에 저장할 만한 데이터만 저장한다.
 */
@Getter
public class CustomUserAuthToken implements Authentication {

    private UserType userType;
    private final Long id;
    private final String username;
    private final String accessToken;
    private boolean authenticated = false;

    public CustomUserAuthToken(Long id, String username, UserType userType) {
        this.id = id;
        this.username = username;
        this.accessToken = null;
        this.userType = userType;
    }

    public CustomUserAuthToken(Long id, String username, String accessToken, UserType userType) {
        this.id = id;
        this.username = username;
        this.accessToken = accessToken;
        this.userType = userType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return null;
    }
}
