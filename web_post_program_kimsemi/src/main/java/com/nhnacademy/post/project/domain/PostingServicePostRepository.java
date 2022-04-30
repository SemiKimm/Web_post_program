package com.nhnacademy.post.project.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PostingServicePostRepository
    implements PostRepository {
    private final Map<Long, Post> posts = new HashMap<>();

    @Override
    public long register(Post post) {
        if (Objects.isNull(post)) {
            throw new IllegalArgumentException();
        }
        this.posts.put(post.getId(), post);
        return post.getId();
    }

    @Override
    public void modify(Post post) {
        if (Objects.isNull(post)) {
            throw new IllegalArgumentException();
        }
        Post modifyPost = getPost(post.getId());
        modifyPost.setContent(post.getContent());
        modifyPost.setWriteTime(post.getWriteTime());
        modifyPost.setTitle(post.getTitle());
    }

    @Override
    public Post remove(long id) {
        if (id == 0L) {
            throw new IllegalArgumentException();
        }
        if (Objects.isNull(getPost(id))) {
            throw new IllegalArgumentException();
        }
        Post resultPost = getPost(id);
        this.posts.remove(id);

        return resultPost;
    }

    @Override
    public Post getPost(long id) {
        if (id == 0L) {
            throw new IllegalArgumentException();
        }
        if(Objects.isNull(this.posts.get(id))){
            throw new IllegalArgumentException();
        }
        return this.posts.get(id);
    }

    @Override
    public List<Post> getPosts() {
        return new ArrayList<>(this.posts.values());
    }
}
