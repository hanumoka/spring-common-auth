package com.sebure.springcommonauth.exception;

import com.sebure.springcommonauth.code.ApiErrorCode;
import com.sebure.springcommonauth.common.dto.ApiResponseOutDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiResponseOutDto<Object>> handleException(Exception e) {
        log.error("handleEntityNotFoundException", e);
        return ApiResponseOutDto.serverError();
    }

    /**
     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
     * - 권한이 필요한 요청이 권한이 없는경우
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<ApiResponseOutDto<Object>> handleAccessDeniedException(AccessDeniedException e) {
        log.error("handleAccessDeniedException", e);
        return ApiResponseOutDto.error(ApiErrorCode.LOGIN_ERROR);
    }

    /**
     * 로그인 실패시
     */
    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<ApiResponseOutDto<Object>> handleBadCredentialsException(BadCredentialsException e) {
        log.error("handleAccessDeniedException", e);
        return ApiResponseOutDto.error(ApiErrorCode.LOGIN_ERROR);
    }


    /**
     *  javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     *  HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
     *  주로 @RequestBody, @RequestPart 어노테이션에서 발생
     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        log.error("handleMethodArgumentNotValidException", e);
//        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

    /**
     * @ModelAttribut 으로 binding error 발생시 BindException 발생한다.
     * ref https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-modelattrib-method-args
     */
//    @ExceptionHandler(BindException.class)
//    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
//        log.error("handleBindException", e);
//        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

    /**
     * enum type 일치하지 않아 binding 못할 경우 발생
     * 주로 @RequestParam enum으로 binding 못했을 경우 발생
     */
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
//        log.error("handleMethodArgumentTypeMismatchException", e);
//        final ErrorResponse response = ErrorResponse.of(e);
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//        log.error("handleHttpRequestMethodNotSupportedException", e);
//        final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
//        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
//    }



//    @ExceptionHandler(BusinessException.class)
//    protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e) {
//        log.error("handleEntityNotFoundException", e);
//        final ErrorCode errorCode = e.getErrorCode();
//        final ErrorResponse response = ErrorResponse.of(errorCode);
//        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
//    }


}