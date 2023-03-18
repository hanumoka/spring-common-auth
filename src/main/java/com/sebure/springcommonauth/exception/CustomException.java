package com.sebure.springcommonauth.exception;

import com.sebure.springcommonauth.code.ApiErrorCode;
import lombok.Data;

public class CustomException extends RuntimeException {
    //TODO: 제네릭의 와일드 카드는 원시타입 제네릭이 지키지 못하는 타입안전성을 보장한다? 어떻게?
    private ApiErrorDto<?> apiErrorDto;

    @Data
    static class ApiErrorDto<T> {
        private ApiErrorCode apiErrorCode;
        private T data;
    }
}
