package com.nhnacademy.post.project.listener;

import com.nhnacademy.post.project.domain.PostRepository;
import com.nhnacademy.post.project.domain.PostingServicePostRepository;
import com.nhnacademy.post.project.domain.PostingServiceUser;
import com.nhnacademy.post.project.domain.PostingServiceUserRepository;
import com.nhnacademy.post.project.domain.SettingUtils;
import com.nhnacademy.post.project.domain.User;
import com.nhnacademy.post.project.domain.UserRepository;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class WebAppListener implements ServletContextListener {
    private PostRepository postRepository;
    private UserRepository userRepository;
    private User adminUser;
    private long postId;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        postRepository = new PostingServicePostRepository();
        userRepository = new PostingServiceUserRepository();
        adminUser = new PostingServiceUser();
        adminUser.setId("admin");
        adminUser.setPassword("12345");
        adminUser.setName("관리자");
        postId = 0L;

        context.setAttribute("postRepository", postRepository);
        context.setAttribute("userRepository", userRepository);
        context.setAttribute("admin", adminUser);
        context.setAttribute("postId",postId);

        SettingUtils.settingCounter(context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String counterFileName = context.getInitParameter("counterFileName");
        int counter = (int) context.getAttribute("counter");

        try (OutputStream out = Files.newOutputStream(
            Paths.get(
                Objects.requireNonNull(getClass().getResource("/" + counterFileName)).toURI()));
             DataOutputStream dos = new DataOutputStream(out)
        ) {
            dos.writeInt(counter);
        } catch (IOException | URISyntaxException e) {
            log.error("", e);
        }
    }
}
