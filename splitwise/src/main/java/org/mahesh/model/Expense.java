package org.mahesh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.mahesh.enums.SplitType;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@AllArgsConstructor
@ToString
public class Expense {
    private final String id;
    private User paidBy;
    private BigDecimal amount;
    private String title;
    private SplitType splitType;
    private Set<Split> splitSet;
}
