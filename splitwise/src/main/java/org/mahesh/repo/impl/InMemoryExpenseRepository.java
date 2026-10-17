package org.mahesh.repo.impl;

import org.mahesh.model.Expense;
import org.mahesh.repo.ExpenseRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryExpenseRepository implements ExpenseRepository {
    private final Map<String, Expense> expenseMap = new ConcurrentHashMap<>();
    @Override
    public void add(Expense expense) {
        expenseMap.put(expense.getId(), expense);
    }

    @Override
    public Optional<Expense> get(String expenseId) {
        return Optional.ofNullable(expenseMap.get(expenseId));
    }
}
