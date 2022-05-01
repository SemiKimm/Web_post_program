package com.nhnacademy.post.project.controller.user;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.PostRepository;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemovePostController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = request.getServletContext();
        String queryString = request.getQueryString();
        long postId = Long.parseLong(queryString.split("=")[1]);

        PostRepository postRepository = (PostRepository) context.getAttribute("postRepository");
        postRepository.remove(postId);
        context.setAttribute("postRepository", postRepository);
        request.getSession().setAttribute("postList",postRepository.getPosts());

        return "redirect:/postList.do";
    }
}
