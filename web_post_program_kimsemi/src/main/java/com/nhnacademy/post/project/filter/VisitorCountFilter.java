package com.nhnacademy.post.project.filter;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(filterName = "visitorCounterFilter", urlPatterns = {"/userList.do", "/postList.do"})
public class VisitorCountFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        ServletContext context = servletRequest.getServletContext();
        Integer counter = (Integer) Optional.ofNullable(context.getAttribute("counter")).orElse(0);
        counter++;
        log.error("현재 누적 방문자 수 : {}", counter);
        context.setAttribute("counter", counter);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
