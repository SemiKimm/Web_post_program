package com.nhnacademy.post.project.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostTest {
    Post post;

    @BeforeEach
    void setUp() {
        post = new PostingServicePost();
    }

    @Test
    void setIdAndGetId() {
        long testId = 1L;
        post.setId(testId);

        long result = post.getId();
        assertThat(result)
            .isNotNull()
            .isEqualTo(1L);
    }

    @Test
    void setTitleAndGetTitle() {
        String testTitle = "testPost";
        post.setTitle(testTitle);

        String result = post.getTitle();
        assertThat(result)
            .isNotNull()
            .isEqualTo("testPost");
    }


    @Test
    void setContentAndGetContent() {
        String testContent = "hello, world";
        post.setContent(testContent);

        String result = post.getContent();
        assertThat(result)
            .isNotNull()
            .isEqualTo("hello, world");
    }


    @Test
    void setWriterUserIdAndGetWriterUserId() {
        String testWriterUserId = "semi";
        post.setWriterUserId(testWriterUserId);

        String result = post.getWriterUserId();
        assertThat(result)
            .isNotNull()
            .isEqualTo("semi");
    }

    @Test
    void setWriteTimeAndGetWriteTime() {
        LocalDateTime testLocalDateTime = LocalDateTime.now();
        post.setWriteTime(testLocalDateTime);

        LocalDateTime result = post.getWriteTime();
        assertThat(result)
            .isNotNull()
            .isEqualTo(testLocalDateTime);
    }

    @Test
    void increaseViewCountAndGetViewCount() {
        post.increaseViewCount();

        int result = post.getViewCount();
        assertThat(result)
            .isNotZero()
            .isEqualTo(1);
    }
}