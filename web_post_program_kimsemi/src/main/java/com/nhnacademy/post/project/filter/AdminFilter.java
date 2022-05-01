package com.nhnacademy.post.project.filter;

import com.nhnacademy.post.project.domain.User;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.SneakyThrows;

@WebFilter(filterName = "adminFilter", urlPatterns = {"/addUser.do", "/modifyUser.do",
    "/modifyUserForm.do", "/profileUpload.do", "/profileUploadForm.do", "/removeUser.do",
    "/userList.do"
})
public class AdminFilter implements Filter {
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {ServletContext context = servletRequest.getServletContext();
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpSession session = httpServletRequest.getSession(false);
        User user = (User) session.getAttribute("user");
        if(Objects.isNull(user)||!user.getId().equals("admin")){
            throw new IllegalAccessException("invalid access");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
