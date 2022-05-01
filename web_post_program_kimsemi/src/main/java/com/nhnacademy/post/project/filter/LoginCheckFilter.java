package com.nhnacademy.post.project.filter;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = {
    "/userList.do", "/addUser.do", "/profileUploadForm.do", "/profileUpload.do",
    "/modifyUserForm.do", "/modifyUser.do", "/removeUser.do",
    "/postList.do","/postingForm.do","/posting.do","/post.do",
    "/removePost.do","/modifyPostForm.do","/modifyPost.do",
    "/writerInfo.do"
})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        if (Objects.isNull(session) || Objects.isNull(session.getAttribute("user"))) {
            ((HttpServletResponse) servletResponse).sendRedirect("/login.do");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
