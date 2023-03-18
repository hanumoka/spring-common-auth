package com.sebure.springcommonauth.controller.dto.out;

import com.sebure.springcommonauth.code.ApiErrorCode;
import com.sebure.springcommonauth.code.ApiSuccessCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class ApiResponseOutDto <T>{
    private final HttpStatus httpStatus;
    private final Integer detailCode;
    private final String message;
    private final T data;

    public ApiResponseOutDto(ApiSuccessCode apiSuccessCode){
        this.httpStatus = apiSuccessCode.getHttpStatus();
        this.detailCode = apiSuccessCode.getDetailCode();
        this.message = apiSuccessCode.getMessage();
        this.data = null;
    }

    public ApiResponseOutDto(ApiSuccessCode apiSuccessCode,T data){
        this.httpStatus = apiSuccessCode.getHttpStatus();
        this.detailCode = apiSuccessCode.getDetailCode();
        this.message = apiSuccessCode.getMessage();
        this.data = data;
    }

    public ApiResponseOutDto(ApiErrorCode apiErrorCode){
        this.httpStatus = apiErrorCode.getHttpStatus();
        this.detailCode = apiErrorCode.getDetailCode();
        this.message = apiErrorCode.getMessage();
        this.data = null;
    }

    public ApiResponseOutDto(ApiErrorCode apiErrorCode, T data){
        this.httpStatus = apiErrorCode.getHttpStatus();
        this.detailCode = apiErrorCode.getDetailCode();
        this.message = apiErrorCode.getMessage();
        this.data = data;
    }

    public static <T> ResponseEntity<ApiResponseOutDto<T>> success() {
        ApiResponseOutDto<T> apiResponseOutDto = new ApiResponseOutDto<>(ApiSuccessCode.OK);
        return new ResponseEntity<>(apiResponseOutDto, apiResponseOutDto.getHttpStatus());
    }
    public static <T> ResponseEntity<ApiResponseOutDto<T>> success(T data) {
        ApiResponseOutDto<T> apiResponseOutDto = new ApiResponseOutDto<>(ApiSuccessCode.OK, data);
        return new ResponseEntity<>(apiResponseOutDto, apiResponseOutDto.getHttpStatus());
    }

    public static <T> ResponseEntity<ApiResponseOutDto<T>> success(ApiSuccessCode apiSuccessCode,T data) {
        ApiResponseOutDto<T> apiResponseOutDto = new ApiResponseOutDto<>(apiSuccessCode, data);
        return new ResponseEntity<>(apiResponseOutDto, apiResponseOutDto.getHttpStatus());
    }

    public static <T> ResponseEntity<ApiResponseOutDto<T>> serverError() {
        ApiResponseOutDto<T> apiResponseOutDto = new ApiResponseOutDto<>(ApiErrorCode.SERVER_ERROR);
        return new ResponseEntity<>(apiResponseOutDto, apiResponseOutDto.getHttpStatus());
    }

    public static <T> ResponseEntity<ApiResponseOutDto<T>> error(ApiErrorCode apiErrorCode) {
        ApiResponseOutDto<T> apiResponseOutDto = new ApiResponseOutDto<>(apiErrorCode);
        return new ResponseEntity<>(apiResponseOutDto, apiResponseOutDto.getHttpStatus());
    }

    public static <T> ResponseEntity<ApiResponseOutDto<T>> error(ApiErrorCode apiErrorCode, T data) {
        ApiResponseOutDto<T> apiResponseOutDto = new ApiResponseOutDto<>(apiErrorCode, data);
        return new ResponseEntity<>(apiResponseOutDto, apiResponseOutDto.getHttpStatus());
    }
}
