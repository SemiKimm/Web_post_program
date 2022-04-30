package com.nhnacademy.post.project.controller.admin;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.PostingServiceUser;
import com.nhnacademy.post.project.domain.User;
import com.nhnacademy.post.project.domain.UserRepository;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyUserController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String profileFileName = request.getParameter("profileFileName");

        User modify = new PostingServiceUser();
        modify.setId(id);
        modify.setPassword(password);
        modify.setName(name);
        modify.setProfileFileName(profileFileName); //todo : 프로필 파일 변경하는거 넣어야되는데..

        ServletContext context = request.getServletContext();
        UserRepository userRepository = (UserRepository) context.getAttribute("userRepository");
        userRepository.modify(modify);
        context.setAttribute("userRepository", userRepository);
        request.getSession().setAttribute("userList", userRepository.getUsers());
        return "redirect:/userList.do";
    }
}
