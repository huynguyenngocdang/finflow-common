package com.huynguyenngocdang.commons.api.response;

import com.huynguyenngocdang.commons.utils.DateUtils;
import org.slf4j.MDC;

import static com.huynguyenngocdang.commons.constants.AppConstants.MDC_REQUEST_DATE_TIME;
import static com.huynguyenngocdang.commons.constants.AppConstants.MDC_REQUEST_ID;

public record ResponseMetadata(String requestId, String requestDateTime, String responseDateTime) {
    public static ResponseMetadata current() {
        return new ResponseMetadata(MDC.get(MDC_REQUEST_ID), MDC.get(MDC_REQUEST_DATE_TIME), DateUtils.getCurrentDateTimeString());
    }
}
