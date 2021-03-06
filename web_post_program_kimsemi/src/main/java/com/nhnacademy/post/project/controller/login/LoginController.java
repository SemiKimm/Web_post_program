package com.nhnacademy.post.project.controller.login;

import com.nhnacademy.post.project.command.Command;
import com.nhnacademy.post.project.domain.Post;
import com.nhnacademy.post.project.domain.PostRepository;
import com.nhnacademy.post.project.domain.User;
import com.nhnacademy.post.project.domain.UserRepository;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //GET
        HttpSession session = request.getSession(false);
        if (Objects.isNull(session) || Objects.isNull(session.getAttribute("user"))) {
            return "redirect:/loginForm.do";
        }
        User user = (User) session.getAttribute("user");
        if (user.getId().equals("admin")) {
            UserRepository userRepository =
                (UserRepository) request.getServletContext().getAttribute("userRepository");
            List<User> userList = userRepository.getUsers();
            request.getSession(false).setAttribute("userList", userList);
            return "redirect:/userList.do";
        } else {
            PostRepository postRepository =
                (PostRepository) request.getServletContext().getAttribute("postRepository");
            List<Post> postList = postRepository.getPosts();
            request.getSession(false).setAttribute("postList", postList);
            return "redirect:/postList.do";
        }
    }
}
