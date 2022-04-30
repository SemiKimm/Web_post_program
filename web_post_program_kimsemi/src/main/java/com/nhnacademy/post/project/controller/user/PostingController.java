package com.nhnacademy.post.project.controller.user;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.Post;
import com.nhnacademy.post.project.domain.PostRepository;
import com.nhnacademy.post.project.domain.PostingServicePost;
import com.nhnacademy.post.project.domain.User;
import java.time.LocalDateTime;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostingController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = request.getServletContext();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        LocalDateTime writeTime = LocalDateTime.now();
        User writerUser = (User) request.getSession().getAttribute("user");
        String writerUserId = writerUser.getId();
        Post post = new PostingServicePost();
        post.setWriterUserId(writerUserId);
        post.setWriteTime(writeTime);
        post.setContent(content);
        post.setTitle(title);
        long postId = (long) context.getAttribute("postId");
        postId++;
        post.setId(postId);

        PostRepository postRepository = (PostRepository) context.getAttribute("postRepository");
        postRepository.register(post);
        context.setAttribute("postRepository", postRepository);
        context.setAttribute("postId", postId);
        request.getSession().setAttribute("postList", postRepository.getPosts());

        return "redirect:/postList.do";
    }
}
