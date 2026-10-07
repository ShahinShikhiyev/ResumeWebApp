package com.mycompany.resumewebapp.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class CustomSecurityServletFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI();

        // Birbaşa .jsp keçidlərini blokiayırıq (infinite redirect əmələ gəlməməsi üçün)
        if (path.contains(".jsp")) {
            response.sendRedirect("index");
            return;
        }
        
        // Statik resurslar və login/logout sorğularına icazə verilir
        if (path.endsWith("login") || path.contains("logout") || path.contains("css") || path.contains("js")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // İstifadəçi daxil olmayıbsa login-ə yönləndir
        final Object loggedInUser = request.getSession().getAttribute("loggedInUser");
        if (loggedInUser == null) {
            response.sendRedirect("login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}