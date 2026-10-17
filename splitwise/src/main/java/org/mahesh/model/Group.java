package org.mahesh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@AllArgsConstructor
@ToString
public class Group {
    private final String id;
    private String name;
    private Set<User> members;
    private boolean defaults;
    private User createdBy;

    public void addMember(User user) {
        this.members.add(user);
    }

    public void removeMember(User user) {
        this.members.remove(user);
    }

    public boolean isDefault() {
        return defaults;
    }
}