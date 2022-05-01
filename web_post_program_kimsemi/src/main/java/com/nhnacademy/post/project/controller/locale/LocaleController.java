package com.nhnacademy.post.project.controller.locale;

import com.nhnacademy.post.project.command.Command;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocaleController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String locale = (String) request.getSession().getAttribute("locale");
        if (locale.equals("ko")) {
            locale = "en";
        } else {
            locale = "ko";
        }
        request.getSession().setAttribute("locale", locale);
        return "redirect:/login.do";
    }
}
