package org.mahesh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduledPayment {
    public enum Status {SCHEDULED, PROCESSED, FAILED}

    private String paymentId;
    private Account sourceAccount;
    private Account targetAccount;
    private long amount;
    private Status status;
    private LocalDateTime scheduledAt;
    private LocalDateTime createdAt;
}