package org.mahesh.repo;

import org.mahesh.model.User;

import java.util.Optional;

public interface UserRepository {
    void add(User user); // Skip if already exist
    Optional<User> get(String userId);
}
