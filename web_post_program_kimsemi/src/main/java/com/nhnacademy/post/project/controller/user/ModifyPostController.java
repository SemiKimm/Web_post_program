package com.nhnacademy.post.project.controller.user;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.Post;
import com.nhnacademy.post.project.domain.PostRepository;
import java.time.LocalDateTime;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyPostController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //fixme:post에서 쿼리스트링이 되나..?
        String queryString = request.getQueryString();
        long postId = Long.parseLong(queryString.split("=")[1]);

        String modifyTitle = request.getParameter("title");
        String modifyContent = request.getParameter("content");
        LocalDateTime modifyWriteTime = LocalDateTime.now();

        ServletContext context = request.getServletContext();
        PostRepository postRepository = (PostRepository) context.getAttribute("postRepository");
        Post post = postRepository.getPost(postId);
        post.setTitle(modifyTitle);
        post.setContent(modifyContent);
        post.setWriteTime(modifyWriteTime);
        postRepository.modify(post);
        context.setAttribute("postRepository", postRepository);
        request.getSession().setAttribute("postList", postRepository.getPosts());

        return "redirect:/postList.do";
    }
}
