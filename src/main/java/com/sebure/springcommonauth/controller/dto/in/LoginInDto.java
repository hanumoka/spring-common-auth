package com.sebure.springcommonauth.controller.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Data
public class LoginInDto {

    @Schema(example = "admin")
    @NotBlank
    private String username;

    @Schema(example = "1234")
    @NotBlank
    private String password;
}
