package org.example.boot.interceptor;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;


@Slf4j
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

}
