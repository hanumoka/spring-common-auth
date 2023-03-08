package com.sebure.springcommonauth.controller.dto.out;

import lombok.Data;

@Data
public class TokenOutDto {
    private String accessToken;
    private String refreshToken;
}
