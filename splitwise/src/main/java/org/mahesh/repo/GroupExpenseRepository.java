package org.mahesh.repo;

import org.mahesh.model.Expense;
import org.mahesh.model.Group;
import org.mahesh.model.GroupExpense;

import java.util.Set;

public interface GroupExpenseRepository {
    void add(GroupExpense groupExpense); // Skip if already exist
    Set<Expense> getAll(Group group);
}
