package com.sebure.springcommonauth.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiErrorCode {
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 5001, "서버에 장애가 발생했습니다."),
    LOGIN_ERROR(HttpStatus.UNAUTHORIZED, 4011, "로그인 실패"),
    AUTHENTICATION_ERROR(HttpStatus.UNAUTHORIZED, 4012, "인증정보 오류")

    ;
    private final HttpStatus httpStatus;
    private final int detailCode;
    private final String message;

    ApiErrorCode(HttpStatus httpStatus, int detailCode, String message) {
        this.httpStatus = httpStatus;
        this.detailCode = detailCode;
        this.message = message;
    }
}
