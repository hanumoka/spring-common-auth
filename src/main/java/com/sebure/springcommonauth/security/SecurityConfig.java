package com.sebure.springcommonauth.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws
            Exception {
        http
                .authorizeRequests()
                .antMatchers("/test").permitAll()
                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .disable()
//                .csrf()
//                .disable()
//                .headers()
//                .disable()
//                .httpBasic()
//                .disable()
//                .rememberMe()
//                .disable()
//                .logout()
//                .disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler())
//                .authenticationEntryPoint(authenticationEntryPoint())
//                .and()
//                .addFilterBefore(jwtAuthenticationFilter(jwt, tokenService), UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }
}
