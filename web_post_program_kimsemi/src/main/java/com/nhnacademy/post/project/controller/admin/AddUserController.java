package com.nhnacademy.post.project.controller.admin;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.PostingServiceUser;
import com.nhnacademy.post.project.domain.PostingServiceUserRepository;
import com.nhnacademy.post.project.domain.User;
import com.nhnacademy.post.project.domain.UserRepository;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pwd = request.getParameter("password");
        String name = request.getParameter("name");
        String profileFileName = request.getParameter("fileName");

        User newUser = new PostingServiceUser();
        newUser.setId(id);
        newUser.setPassword(pwd);
        newUser.setName(name);
        newUser.setProfileFileName(profileFileName);

        ServletContext context = request.getServletContext();
        UserRepository userRepository = (UserRepository) context.getAttribute("userRepository");
        userRepository.add(newUser);

        request.getServletContext().setAttribute("userRepository",userRepository);
        request.getSession().setAttribute("userList",userRepository.getUsers());

        return "redirect:/userList.do";
    }
}
