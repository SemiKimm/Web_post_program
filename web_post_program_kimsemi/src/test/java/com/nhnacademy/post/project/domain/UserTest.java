package com.nhnacademy.post.project.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    User user;
    @BeforeEach
    void setUp() {
        user = new PostingServiceUser();
    }

    @DisplayName("setId 를 한 후에 user 의 id 는 null 이 아니다.")
    @Test
    void setIdAndGetId() {
        String testId = "semi";
        user.setId(testId);

        String result = user.getId();
        assertThat(result)
            .isNotNull()
            .isEqualTo("semi");
    }

    @DisplayName("setPassword 를 한 후에 user 의 password 는 null 이 아니다.")
    @Test
    void setPasswordAndGetPassword() {
        String testPassword = "1234";
        user.setPassword(testPassword);

        String result = user.getPassword();
        assertThat(result)
            .isNotNull()
            .isEqualTo("1234");
    }

    @DisplayName("setName 를 한 후에 user 의 name 은 null 이 아니다.")
    @Test
    void setNameAndGetName() {
        String testName = "김세미";
        user.setName(testName);

        String result = user.getName();
        assertThat(result)
            .isNotNull()
            .isEqualTo("김세미");
    }

    @DisplayName("setProfileFileName 을 한 후에 user 의 profileName 은 null 이 아니다.")
    @Test
    void setProfileFileNameAndGetProfileFileName() {
        String testProfileFileName = "test.img";
        user.setProfileFileName(testProfileFileName);

        String result = user.getProfileFileName();
        assertThat(result)
            .isNotNull()
            .isEqualTo("test.img");
    }
}