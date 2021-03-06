package com.nhnacademy.post.project.servlet;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.controller.locale.LocaleController;
import com.nhnacademy.post.project.controller.admin.AddUserController;
import com.nhnacademy.post.project.controller.admin.ModifyUserController;
import com.nhnacademy.post.project.controller.admin.ModifyUserFormController;
import com.nhnacademy.post.project.controller.admin.ProfileUploadController;
import com.nhnacademy.post.project.controller.admin.ProfileUploadFormController;
import com.nhnacademy.post.project.controller.admin.RemoveUserController;
import com.nhnacademy.post.project.controller.admin.UserListController;
import com.nhnacademy.post.project.controller.login.LoginController;
import com.nhnacademy.post.project.controller.login.LoginFormController;
import com.nhnacademy.post.project.controller.login.LoginProcessingController;
import com.nhnacademy.post.project.controller.logout.LogoutController;
import com.nhnacademy.post.project.controller.user.ModifyPostController;
import com.nhnacademy.post.project.controller.user.ModifyPostFormController;
import com.nhnacademy.post.project.controller.user.PostController;
import com.nhnacademy.post.project.controller.user.PostListController;
import com.nhnacademy.post.project.controller.user.PostingController;
import com.nhnacademy.post.project.controller.user.PostingFormController;
import com.nhnacademy.post.project.controller.user.RemovePostController;
import com.nhnacademy.post.project.controller.user.WriterInfoController;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            Command command = resolveCommand(req.getServletPath(), req.getMethod());
            String view = command.execute(req, resp);
            if (Objects.isNull(view)) {
                throw new IllegalArgumentException();
            }
            if (view.startsWith(REDIRECT_PREFIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception ex) {
            log.error("", ex);
            req.setAttribute("exception", ex);
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;
        if ("/login.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LoginController();
        } else if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new LoginProcessingController();
        } else if ("/loginForm.do".equalsIgnoreCase(servletPath) &&
            "GET".equalsIgnoreCase(method)) {
            command = new LoginFormController();
        } else if ("/userList.do".equalsIgnoreCase(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new UserListController();
        } else if ("/addUser.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new AddUserController();
        } else if ("/profileUploadForm.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new ProfileUploadFormController();
        } else if ("/profileUpload.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new ProfileUploadController();
        } else if ("/modifyUserForm.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new ModifyUserFormController();
        } else if ("/modifyUser.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new ModifyUserController();
        } else if ("/removeUser.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new RemoveUserController();
        } else if ("/logout.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LogoutController();
        } else if ("/postList.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new PostListController();
        } else if ("/postingForm.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new PostingFormController();
        } else if ("/posting.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new PostingController();
        } else if ("/post.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new PostController();
        } else if ("/removePost.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new RemovePostController();
        } else if ("/modifyPostForm.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new ModifyPostFormController();
        } else if ("/modifyPost.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new ModifyPostController();
        } else if ("/writerInfo.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new WriterInfoController();
        } else if ("/locale.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LocaleController();
        }
        return command;
    }
}
