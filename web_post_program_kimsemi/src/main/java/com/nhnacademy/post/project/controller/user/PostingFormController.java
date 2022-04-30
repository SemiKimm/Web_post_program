package com.nhnacademy.post.project.controller.user;

import com.nhnacademy.post.project.command.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostingFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/postingForm.jsp";
    }
}
