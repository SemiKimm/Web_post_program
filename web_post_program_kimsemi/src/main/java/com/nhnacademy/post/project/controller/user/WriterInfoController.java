package com.nhnacademy.post.project.controller.user;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.User;
import com.nhnacademy.post.project.domain.UserRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriterInfoController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String queryString = request.getQueryString();
        String writerUserId = queryString.split("=")[1];

        UserRepository userRepository =
            (UserRepository) request.getServletContext().getAttribute("userRepository");
        User writer = userRepository.getUser(writerUserId);

        request.setAttribute("writerInfo", writer);
        return "/writerInfo.jsp";
    }
}
