package org.mahesh.repo.impl;

import org.mahesh.model.User;
import org.mahesh.repo.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public void add(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public Optional<User> get(String userId) {
        return Optional.ofNullable(userMap.get(userId));
    }
}
