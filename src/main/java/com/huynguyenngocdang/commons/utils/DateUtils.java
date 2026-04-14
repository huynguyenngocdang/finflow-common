package com.huynguyenngocdang.commons.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;

import static com.huynguyenngocdang.commons.constants.AppConstants.ZONE_ID;
import static com.huynguyenngocdang.commons.constants.AppConstants.ZONE_ID_DEFAULT;

@Component
public class DateUtils {
    public static String getCurrentDateTimeString() {
        return OffsetDateTime.now(ZONE_ID).toString();
    }

    public static String getCurrentDateString() {
        return LocalDate.now(ZONE_ID).toString();
    }

}
