package com.sebure.springcommonauth.security;

import com.sebure.springcommonauth.security.authmamager.AuthManager;
import com.sebure.springcommonauth.security.jwt.JwtProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthManager authManager;

    public JwtAuthenticationFilter(AuthManager authManager) {
        this.authManager = authManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("doFilter : " + request.getRequestURI());

        try{
            authManager.checkRequestAuth(request);
        } catch (Exception e){
            e.printStackTrace();
            log.warn(e.getMessage());
        }

        filterChain.doFilter(request, response);
    }
}
