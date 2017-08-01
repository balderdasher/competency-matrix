package com.mrdios.competencymatrix.springboot.example.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义过滤器用于显示请求地址
 *
 * @author MrDios
 * @date 2017-08-01
 */
public class RequestAccessFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("Access request ip: " + req.getRequestURI());
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
