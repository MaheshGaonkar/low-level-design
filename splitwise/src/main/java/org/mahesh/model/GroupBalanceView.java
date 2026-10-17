package org.mahesh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@AllArgsConstructor
public class GroupBalanceView {
    private final Group group;
    private final Map<User, BigDecimal> userOwesMap;
    private final Map<User, BigDecimal> userBorrowedMap;
}