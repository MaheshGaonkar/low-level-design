package org.mahesh.repo;

import org.mahesh.model.Group;
import org.mahesh.model.User;

import java.util.Optional;

public interface GroupRepository {
    void add(Group group); // Skip if already exist
    Optional<Group> get(String groupId);
    void addMember(String groupId, User user);
}
