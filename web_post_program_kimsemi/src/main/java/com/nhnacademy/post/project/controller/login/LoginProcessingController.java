package com.nhnacademy.post.project.controller.login;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.User;
import com.nhnacademy.post.project.domain.UserRepository;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProcessingController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //POST
        String id = request.getParameter("userId");
        String pwd = request.getParameter("userPassword");
        ServletContext context = request.getServletContext();
        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session)) {
            session.invalidate();
        }

        User admin = (User) context.getAttribute("admin");
        if (id.equals(admin.getId()) && pwd.equals(admin.getPassword())) {
            session = request.getSession();
            session.setAttribute("user", admin);
            return "redirect:/login.do";
        }

        UserRepository userRepository =
            (UserRepository) context.getAttribute("userRepository");
        User user = userRepository.getUser(id);
        if (Objects.isNull(user) || !pwd.equals(user.getPassword())) {
            throw new IllegalArgumentException();
        }

        session = request.getSession();
        session.setAttribute("user", user);
        return "redirect:/login.do";
    }
}
