package com.nhnacademy.post.project.controller.admin;

import com.nhnacademy.post.project.command.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/userList.jsp";
    }
}
