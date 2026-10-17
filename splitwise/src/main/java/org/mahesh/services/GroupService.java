package org.mahesh.services;

import org.mahesh.exception.GroupNotFoundException;
import org.mahesh.model.Group;
import org.mahesh.model.User;
import org.mahesh.repo.GroupRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public String create(String name, User user) {
        Set<User> members = new HashSet<>();
        members.add(user);
        Group group = new Group(UUID.randomUUID().toString(), name, members, false, user);
        groupRepository.add(group);
        return group.getId();
    }

    public Group getGroup(String groupId) throws GroupNotFoundException {
        return groupRepository.get(groupId).orElseThrow(GroupNotFoundException::new);
    }

    public void addMember(String groupId, User user) {
        groupRepository.addMember(groupId, user);
    }
}