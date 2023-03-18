package com.sebure.springcommonauth.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiSuccessCode {
    OK(HttpStatus.OK, 2001, "성공")
    ;
    private final HttpStatus httpStatus;
    private final int detailCode;
    private final String message;

    ApiSuccessCode(HttpStatus httpStatus, int detailCode, String message) {
        this.httpStatus = httpStatus;
        this.detailCode = detailCode;
        this.message = message;
    }
}
