package com.nhnacademy.post.project.controller.user;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.Post;
import com.nhnacademy.post.project.domain.PostRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyPostFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String queryString = request.getQueryString();
        long postId = Long.parseLong(queryString.split("=")[1]);

        PostRepository postRepository =
            (PostRepository) request.getServletContext().getAttribute("postRepository");

        Post originPost = postRepository.getPost(postId);
        request.setAttribute("post", originPost);

        return "/modifyPostForm.jsp";
    }
}
