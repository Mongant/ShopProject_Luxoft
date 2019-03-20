package com.gorbunov.servlets.filters;

import com.gorbunov.validator.BusinessException;
import com.gorbunov.validator.ValidationService;
import com.gorbunov.validator.ValidationServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(urlPatterns = "/clients")
public class ClientFilter implements Filter {

    private ValidationService validationService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.validationService = new ValidationServiceImpl();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        int ageInt;
        String age = servletRequest.getParameter("age");
        try {
            ageInt = Integer.parseInt(age);
            validationService.validateAge(ageInt);
        } catch (NumberFormatException e) {
            PrintWriter out = servletResponse.getWriter();
            out.println("<h2> WRONG AGE </h2>");
            return;
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
