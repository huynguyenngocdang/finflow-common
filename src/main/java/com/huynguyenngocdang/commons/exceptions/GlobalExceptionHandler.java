package com.huynguyenngocdang.commons.exceptions;

import com.huynguyenngocdang.commons.api.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.huynguyenngocdang.commons.constants.AppConstants.API_ERROR_CODE;
import static com.huynguyenngocdang.commons.constants.AppConstants.CLIENT_SIDE_ERROR_CODE;
import static com.huynguyenngocdang.commons.constants.AppConstants.REQUEST_BODY_MISSING_ERROR_MESSAGE;
import static com.huynguyenngocdang.commons.constants.AppConstants.VALIDATION_ERROR_MESSAGE;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseApi<Object>> handleException(Exception ex) {
        log.error("Global Exception: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseApi.fail(API_ERROR_CODE, ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseApi<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("MethodArgumentNotValidException: {}", ex.getMessage(), ex);
        Map<String, String > errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        fieldError -> Optional.ofNullable(fieldError.getDefaultMessage()).orElse(VALIDATION_ERROR_MESSAGE)
                ));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseApi.fail(errors, API_ERROR_CODE, VALIDATION_ERROR_MESSAGE));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseApi<Object>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.error("HttpMessageNotReadableException: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseApi.fail(CLIENT_SIDE_ERROR_CODE, REQUEST_BODY_MISSING_ERROR_MESSAGE));
    }
}
