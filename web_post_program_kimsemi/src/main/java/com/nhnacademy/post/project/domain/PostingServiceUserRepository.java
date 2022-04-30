package com.nhnacademy.post.project.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PostingServiceUserRepository
    implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void add(User user) {
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("null");
        }
        this.users.put(user.getId(), user);
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
        // FIXME : 사용자 id 도 바꿀수 있게 해야되나??
        existUser.setProfileFileName(user.getPassword());
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
        this.users.remove(id);
        return removeUser;
    }

    @Override
    public User getUser(String id) {
        if(Objects.isNull(id)){
            throw new IllegalArgumentException();
        }
        if(Objects.isNull(this.users.get(id))){
            throw new IllegalArgumentException();
        }
        return this.users.get(id);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(this.users.values());
    }
}
