package com.nhnacademy.post.project.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostRepositoryTest {
    PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository = new PostingServicePostRepository();
    }

    @Test
    void register() {
        Post testPost = new PostingServicePost();
        testPost.setId(1L);

        long result = postRepository.register(testPost);
        assertThat(result)
            .isNotZero()
            .isEqualTo(1L);
    }

    @Test
    void register_postIsNull_throwIllegalArgumentExp() {
        Post testPost = null;
        assertThatIllegalArgumentException()
            .isThrownBy(() -> postRepository.register(testPost));
    }

    @Test
    void modify_postIsNull_throwIllegalArgumentExp() {
        Post post = null;
        assertThatIllegalArgumentException()
            .isThrownBy(() -> postRepository.modify(post));
    }

    @Test
    void remove_idIsZero_throwIllegalArgumentExp() {
        long testId = 0L;
        assertThatIllegalArgumentException()
            .isThrownBy(() -> postRepository.remove(testId));
    }

    @Test
    void getPost() {
        long testId = 1L;
        Post testPost = new PostingServicePost();
        testPost.setId(testId);
        postRepository.register(testPost);

        Post result = postRepository.getPost(testId);
        assertThat(result)
            .isNotNull()
            .isEqualTo(testPost);
    }

    @Test
    void getPost_idIsZero_throwIllegalArgumentExp() {
        long testId = 0L;
        assertThatIllegalArgumentException()
            .isThrownBy(() -> postRepository.getPost(testId));
    }

    @Test
    void getPosts() {
        long testId = 1L;
        Post testPost = new PostingServicePost();
        testPost.setId(testId);
        postRepository.register(testPost);

        List<Post> result = postRepository.getPosts();
        assertThat(result)
            .isNotNull();
        assertThatNoException()
            .isThrownBy(() -> postRepository.getPosts());
    }
}