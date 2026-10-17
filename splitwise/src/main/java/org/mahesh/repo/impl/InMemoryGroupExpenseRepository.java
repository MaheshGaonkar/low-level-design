package org.mahesh.repo.impl;

import org.mahesh.model.Expense;
import org.mahesh.model.Group;
import org.mahesh.model.GroupExpense;
import org.mahesh.repo.GroupExpenseRepository;

import java.util.*;

public class InMemoryGroupExpenseRepository implements GroupExpenseRepository {

    private final Map<Group, Set<Expense>> groupExpenseMap = new HashMap<>();

    @Override
    public void add(GroupExpense groupExpense) {
        if (groupExpenseMap.containsKey(groupExpense.getGroup())) {
            groupExpenseMap.put(groupExpense.getGroup(), new HashSet<>());
        }
        groupExpenseMap.get(groupExpense.getGroup()).add(groupExpense.getExpense());
    }

    @Override
    public Set<Expense> getAll(Group group) {
        return groupExpenseMap.getOrDefault(group, new HashSet<>());
    }
}