package com.nhnacademy.post.project.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PostingServiceUserRepository
    implements UserRepository {
    private final Map<String, User> repository = new HashMap<>();

    @Override
    public void add(User user) {
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("null");
        }
        this.repository.put(user.getId(), user);
    }

    @Override
    public void modify(User user) {
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException();
        }
        if (Objects.isNull(getUser(user.getId()))) {
            throw new IllegalArgumentException();
        }
        User existUser = getUser(user.getId());
        existUser.setName(user.getName());
        existUser.setProfileFileName(user.getProfileFileName());
    }

    @Override
    public User remove(String id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException();
        }
        if (Objects.isNull(getUser(id))) {
            throw new IllegalArgumentException();
        }
        User removeUser = getUser(id);
        getUsers().remove(removeUser);
        return removeUser;
    }

    @Override
    public User getUser(String id) {
        if(Objects.isNull(id)){
            throw new IllegalArgumentException();
        }
        List<User> users = getUsers();
        return users
            .stream()
            .filter(user->user.getId().equals(id)).findFirst()
            .orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) this.repository.values();
    }
}
