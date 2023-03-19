package com.sebure.springcommonauth.security.jwt;

import com.sebure.springcommonauth.common.dto.TokenDto;
import com.sebure.springcommonauth.security.CustomUserAuthToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
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
            , @Value("${custom.jwt.refresh-token.expiration-milliseconds}")Long refreshTokenExpiration) {

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


//    public String generateToken(String username) {
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + jwtExpiration);
//
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(now)
//                .setExpiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }
//
//    public String getUsernameFromJwt(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(jwtSecret)
//                .parseClaimsJws(token)
//                .getBody();
//
//        return claims.getSubject();
//    }
//
//    public boolean validateToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//            return true;
//        } catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
//            // Invalid JWT signature or unsupported JWT format
//        } catch (ExpiredJwtException ex) {
//            // Expired JWT token
//        }
//
//        return false;
//    }

}
