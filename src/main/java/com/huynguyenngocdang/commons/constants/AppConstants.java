package com.huynguyenngocdang.commons.constants;

import java.time.ZoneId;

public class AppConstants {
    public static final String ZONE_ID_DEFAULT = "Asia/Ho_Chi_Minh";
    public static final ZoneId ZONE_ID = ZoneId.of(ZONE_ID_DEFAULT);
    public static final String MDC_REQUEST_ID = "requestId";
    public static final String MDC_REQUEST_DATE_TIME = "requestDateTime";
    public static final String HEADER_REQUEST_ID = "X-Correlation-ID";
    public static final String API_SUCCESS_CODE = "200";
    public static final String API_SUCCESS_MESSAGE = "SUCCESS";
    public static final String API_ERROR_CODE = "500";
    public static final String API_ERROR_MESSAGE = "ERROR";
    public static final String CLIENT_SIDE_ERROR_CODE = "400";
    public static final String VALIDATION_ERROR_MESSAGE = "Validation error";
    public static final String REQUEST_BODY_MISSING_ERROR_MESSAGE = "Request body is missing or malformed";
}
