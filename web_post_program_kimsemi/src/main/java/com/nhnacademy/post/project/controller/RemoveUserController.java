package com.nhnacademy.post.project.controller;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.UserRepository;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveUserController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String queryString = request.getQueryString();
        String removeUserId = queryString.split("=")[1];

        ServletContext context = request.getServletContext();
        UserRepository userRepository = (UserRepository) context.getAttribute("userRepository");
        userRepository.remove(removeUserId);

        request.getSession().setAttribute("userList", userRepository.getUsers());
        context.setAttribute("userRepository", userRepository);
        return "redirect:/userList.do";
    }
}
