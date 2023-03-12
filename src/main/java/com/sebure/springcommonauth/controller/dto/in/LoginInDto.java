package com.sebure.springcommonauth.controller.dto.in;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Data
public class LoginInDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
