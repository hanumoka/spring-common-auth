package com.sebure.springcommonauth.common.dto;

import lombok.Data;

@Data
public class TokenDto {
    private String accessToken;
    private String refreshToken;
}
