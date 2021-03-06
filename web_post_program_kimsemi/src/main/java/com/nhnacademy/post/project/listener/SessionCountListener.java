package com.nhnacademy.post.project.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class SessionCountListener implements HttpSessionListener {
    private int sessionCount = -2;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionCount++;
        se.getSession().setAttribute("loginUserCounter",sessionCount);
        String locale = (String) se.getSession().getServletContext().getAttribute("locale");
        se.getSession().setAttribute("locale",locale);
        log.error("session count : {}", this.sessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionCount--;
        se.getSession().setAttribute("loginUserCounter",sessionCount);
        log.error("session count : {}", this.sessionCount);
    }
}