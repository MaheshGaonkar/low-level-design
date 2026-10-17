package org.mahesh.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Getter
public class UserLedger {
    private final User user;
    private final Map<User, BigDecimal> userOwesMap = new HashMap<>();
    private final Map<User, BigDecimal> userBorrowedMap = new HashMap<>();

    public UserLedger(User user) {
        this.user = user;
    }

    public void addOwes(User user, BigDecimal amount) {
        BigDecimal currentAmount = userOwesMap.getOrDefault(user, BigDecimal.ZERO);
        userOwesMap.put(user, currentAmount.add(amount));
    }

    public void addBorrowed(User user, BigDecimal amount) {
        BigDecimal currentAmount = userBorrowedMap.getOrDefault(user, BigDecimal.ZERO);
        userBorrowedMap.put(user, currentAmount.add(amount));
    }

    public void removeOwes(User user) {
        userOwesMap.remove(user);
    }

    public void addBorrowed(User user) {
        userBorrowedMap.remove(user);
    }
}