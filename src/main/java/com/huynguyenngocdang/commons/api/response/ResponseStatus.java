package com.huynguyenngocdang.commons.api.response;

import org.springframework.util.StringUtils;

import static com.huynguyenngocdang.commons.constants.AppConstants.API_ERROR_CODE;
import static com.huynguyenngocdang.commons.constants.AppConstants.API_ERROR_MESSAGE;
import static com.huynguyenngocdang.commons.constants.AppConstants.API_SUCCESS_CODE;
import static com.huynguyenngocdang.commons.constants.AppConstants.API_SUCCESS_MESSAGE;

public record ResponseStatus(String code, String message) {
    public static ResponseStatus success() {
        return new ResponseStatus(API_SUCCESS_CODE, API_SUCCESS_MESSAGE);
    }
    public static ResponseStatus fail(String code, String message) {
        if (!StringUtils.hasText(code)) code = API_ERROR_CODE;
        if (!StringUtils.hasText(message)) message = API_ERROR_MESSAGE;
        return new ResponseStatus(code, message);
    }
}
