package org.mahesh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GroupExpense {
    private Group group;
    private Expense expense;
}