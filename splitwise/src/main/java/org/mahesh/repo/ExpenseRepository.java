package org.mahesh.repo;

import org.mahesh.model.Expense;

import java.util.Optional;

public interface ExpenseRepository {
    void add(Expense expense); // Skip if already exist
    Optional<Expense> get(String expenseId);
}
