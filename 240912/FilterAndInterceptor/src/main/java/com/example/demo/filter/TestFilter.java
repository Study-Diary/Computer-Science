package com.example.demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("========== Filter init ==========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        log.info("========== Filter doFilter ==========");

        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        log.info(httpRequest.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("========== Filter doFilter ==========");
    }

    @Override
    public void destroy() {
        log.info("========== Filter destroy ==========");
    }
}
