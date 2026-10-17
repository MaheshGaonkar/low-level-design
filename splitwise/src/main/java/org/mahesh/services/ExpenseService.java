package org.mahesh.services;

import org.mahesh.enums.SplitType;
import org.mahesh.model.Expense;
import org.mahesh.model.Split;
import org.mahesh.model.User;
import org.mahesh.repo.ExpenseRepository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public String create(String title, BigDecimal amount, List<User> partsOf, User paidBy, SplitType splitType) {
        Set<Split> userSplits = new HashSet<>();
        Expense expense = new Expense(UUID.randomUUID().toString(), paidBy, amount, title, splitType, userSplits);
        expenseRepository.add(expense);
        return expense.getId();
    }
}