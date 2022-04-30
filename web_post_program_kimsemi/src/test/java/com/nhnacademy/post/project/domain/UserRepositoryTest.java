package com.nhnacademy.post.project.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.mock;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {
    UserRepository userRepository;
    UserRepository testUserRepository;

    @BeforeEach
    void setUp() {
        userRepository = new PostingServiceUserRepository();
        testUserRepository = mock(PostingServiceUserRepository.class);
    }

    @Test
    void add_testUserIsNull_throwIllegalArgumentExp() {
        User testUser = null;
        assertThatIllegalArgumentException()
            .isThrownBy(() -> userRepository.add(testUser))
            .withMessageContaining("null");
    }

    @Test
    void modify_notExistUser_throwIllegalArgumentException() {
        User modifyUser = null;
        assertThatIllegalArgumentException()
            .isThrownBy(() -> userRepository.modify(modifyUser));
    }

    @Test
    void remove_idIsNull_throwIllegalArgumentExp() {
        String testId = null;
        assertThatIllegalArgumentException()
            .isThrownBy(() -> userRepository.remove(testId));
    }

    @Test
    void getUser(){
        String testId = "semi";
        User testUser = new PostingServiceUser();
        testUser.setId(testId);
        userRepository.add(testUser);

        User result = userRepository.getUser(testId);
        assertThat(result)
            .isNotNull()
            .isEqualTo(testUser);
    }

    @Test
    void getUser_idIsNull_throwIllegalArgumentExp() {
        String testId = null;
        assertThatIllegalArgumentException()
            .isThrownBy(() -> userRepository.getUser(testId));
    }

    @Test
    void getUsers() {
        assertThatNoException()
            .isThrownBy(()->userRepository.getUsers());
    }
}