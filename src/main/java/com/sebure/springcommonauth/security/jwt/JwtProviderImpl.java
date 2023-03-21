package com.sebure.springcommonauth.security.jwt;

import com.sebure.springcommonauth.code.UserType;
import com.sebure.springcommonauth.common.dto.TokenDto;
import com.sebure.springcommonauth.security.CustomUserAuthToken;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtProviderImpl implements JwtProvider {

    private final SecretKey accessTokenSecretKey;
    private final SecretKey refreshTokenSecretKey;
    private final Long accessTokenExpiration;
    private final Long refreshTokenExpiration;

    public JwtProviderImpl(
            @Value("${custom.jwt.access-token.secret-key}") String accessTokenSecretKey
            , @Value("${custom.jwt.refresh-token.secret-key}") String refreshTokenSecretKey
            , @Value("${custom.jwt.access-token.expiration-milliseconds}") Long accessTokenExpiration
            , @Value("${custom.jwt.refresh-token.expiration-milliseconds}") Long refreshTokenExpiration) {

        this.accessTokenSecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(accessTokenSecretKey));
        this.refreshTokenSecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(refreshTokenSecretKey));
        this.accessTokenExpiration = accessTokenExpiration;
        this.refreshTokenExpiration = refreshTokenExpiration;
    }

    @Override
    public TokenDto generateTokens(Authentication authentication) {
        CustomUserAuthToken customUserAuthToken = (CustomUserAuthToken) authentication;
        Date now = new Date();
        Date accessTokenExpiryDate = new Date(now.getTime() + accessTokenExpiration);
        Date refreshTokenExpiryDate = new Date(now.getTime() + refreshTokenExpiration);

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", customUserAuthToken.getId());
        claims.put("username", customUserAuthToken.getUsername());
        claims.put("usertype", customUserAuthToken.getUserType());

        String accessToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(accessTokenExpiryDate)
                .signWith(accessTokenSecretKey, SignatureAlgorithm.HS512)
                .compact();

        String refreshToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(refreshTokenExpiryDate)
                .signWith(refreshTokenSecretKey, SignatureAlgorithm.HS512)
                .compact();

        return new TokenDto(accessToken, refreshToken);
    }

    @Override
    public String getAccessTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    @Override
    public boolean validateAccessToken(String accessToken) {
        try {
            Jwts.parserBuilder().setSigningKey(accessTokenSecretKey).build().parseClaimsJws(accessToken);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

    @Override
    public Long getIdFromAccessToken(String accessToken) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(accessTokenSecretKey).build().parseClaimsJws(accessToken);
        Claims claims = claimsJws.getBody();
        return Long.valueOf(String.valueOf(claims.get("id")));
    }

    @Override
    public UserType getUserTypeFromAccessToken(String accessToken) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(accessTokenSecretKey).build().parseClaimsJws(accessToken);
        Claims claims = claimsJws.getBody();
        return UserType.valueOf(String.valueOf(claims.get("usertype")));
    }

    @Override
    public String getUserNameFromAccessToken(String accessToken) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(accessTokenSecretKey).build().parseClaimsJws(accessToken);
        Claims claims = claimsJws.getBody();
        return String.valueOf(claims.get("username"));
    }

}
