package com.nhnacademy.post.project.controller.admin;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.User;
import com.nhnacademy.post.project.domain.UserRepository;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyUserFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String l = request.getQueryString();
        String queryId = l.split("=")[1];
        ServletContext context = request.getServletContext();
        UserRepository userRepository = (UserRepository) context.getAttribute("userRepository");
        User user = userRepository.getUser(queryId);
        request.getSession().setAttribute("modifyUser",user);
        return "/modifyUserForm.jsp";
    }
}
