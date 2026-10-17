package org.mahesh.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class Account {
    public enum Status {ACTIVE, IN_ACTIVE, CLOSED}
    private String accountId;
    private AtomicLong balance = new AtomicLong(0);
    private LocalDateTime createdAt;

    public Account(String accountId, LocalDateTime createdAt) {
        this.accountId = accountId;
        this.createdAt = createdAt;
    }
}
