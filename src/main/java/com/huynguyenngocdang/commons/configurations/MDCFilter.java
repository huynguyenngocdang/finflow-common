package com.huynguyenngocdang.commons.configurations;

import com.huynguyenngocdang.commons.utils.DateUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.huynguyenngocdang.commons.constants.AppConstants.HEADER_REQUEST_ID;
import static com.huynguyenngocdang.commons.constants.AppConstants.MDC_REQUEST_DATE_TIME;
import static com.huynguyenngocdang.commons.constants.AppConstants.MDC_REQUEST_ID;

@Component
@RequiredArgsConstructor
public class MDCFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String requestId = request.getHeader(HEADER_REQUEST_ID);
            if (requestId == null) {
                requestId = java.util.UUID.randomUUID().toString();
            }
            MDC.put(MDC_REQUEST_ID, requestId);
            MDC.put(MDC_REQUEST_DATE_TIME, DateUtils.getCurrentDateTimeString());
            filterChain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }
}
