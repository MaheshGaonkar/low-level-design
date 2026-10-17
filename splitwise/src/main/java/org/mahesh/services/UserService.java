package org.mahesh.services;

import org.mahesh.excpetion.UserNotFoundException;
import org.mahesh.model.User;
import org.mahesh.repo.UserRepository;

import java.util.UUID;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(String name) {
        User user = new User(UUID.randomUUID().toString(), name);
        userRepository.add(user);
        return user.getId();
    }

    public User getUser(String userId) throws UserNotFoundException {
        return userRepository.get(userId).orElseThrow(UserNotFoundException::new);
    }
}