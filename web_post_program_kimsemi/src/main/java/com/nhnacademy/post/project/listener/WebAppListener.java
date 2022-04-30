package com.nhnacademy.post.project.listener;

import com.nhnacademy.post.project.domain.PostRepository;
import com.nhnacademy.post.project.domain.PostingServicePostRepository;
import com.nhnacademy.post.project.domain.PostingServiceUser;
import com.nhnacademy.post.project.domain.PostingServiceUserRepository;
import com.nhnacademy.post.project.domain.User;
import com.nhnacademy.post.project.domain.UserRepository;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppListener implements ServletContextListener {
    PostRepository postRepository;
    UserRepository userRepository;
    User adminUser;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        postRepository = new PostingServicePostRepository();
        userRepository = new PostingServiceUserRepository();
        adminUser = new PostingServiceUser();
        adminUser.setId("admin");
        adminUser.setPassword("12345");
        adminUser.setName("관리자");

        context.setAttribute("postRepository", postRepository);
        context.setAttribute("userRepository", userRepository);
        context.setAttribute("admin", adminUser);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
