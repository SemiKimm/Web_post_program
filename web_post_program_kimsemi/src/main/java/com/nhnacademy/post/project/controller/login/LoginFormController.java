package com.nhnacademy.post.project.controller.login;

import com.nhnacademy.post.project.command.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/loginForm.jsp";
    }
}
