package org.simple.sm.filter;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.common.constant.ConstantReqMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * the filter for getting req and res body parameter
 */
@Slf4j
@Component
public class ServerMgrLogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        ContentCachingRequestWrapper req = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper resp = new ContentCachingResponseWrapper(response);

        try {
            // Execution request chain
            filterChain.doFilter(req, resp);
            // Get body
            byte[] requestBody = req.getContentAsByteArray();
            byte[] responseBody = resp.getContentAsByteArray();
            if(ConstantReqMethod.GET.equals(request.getMethod())){
                log.info("{}:{}",request.getMethod(), request.getRequestURI());
            }else {
                log.info("{}:{} PARAM:{}",request.getMethod(), request.getRequestURI(), "\n" + new String(requestBody, StandardCharsets.UTF_8));
            }
            log.info("response: {}", new String(responseBody, StandardCharsets.UTF_8));
        } finally {
            // Finally remember to respond to the client with the cached data.
            resp.copyBodyToResponse();
        }
    }
}

