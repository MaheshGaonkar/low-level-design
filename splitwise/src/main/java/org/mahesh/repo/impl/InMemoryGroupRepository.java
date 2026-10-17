package org.mahesh.repo.impl;

import org.mahesh.model.Group;
import org.mahesh.model.User;
import org.mahesh.repo.GroupRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryGroupRepository implements GroupRepository {
    private final Map<String, Group> groupMap = new HashMap<>();
    @Override
    public void add(Group group) {
        groupMap.put(group.getId(), group);
    }

    @Override
    public Optional<Group> get(String groupId) {
        return Optional.ofNullable(groupMap.get(groupId));
    }

    @Override
    public void addMember(String groupId, User user) {
        if (groupMap.containsKey(groupId)) {
            groupMap.get(groupId).addMember(user);
        }
    }
}
