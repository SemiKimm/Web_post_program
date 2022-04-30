package com.nhnacademy.post.project.controller.user;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.Post;
import com.nhnacademy.post.project.domain.PostRepository;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String queryString = request.getQueryString();
        long postId = Long.parseLong(queryString.split("=")[1]);

        ServletContext context = request.getServletContext();
        PostRepository postRepository = (PostRepository) context.getAttribute("postRepository");
        Post post = postRepository.getPost(postId);

        request.setAttribute("post", post);
        return "/post.jsp";
    }
}
