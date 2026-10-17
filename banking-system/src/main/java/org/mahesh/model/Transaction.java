package org.mahesh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {

    public enum Type {DEPOSIT, WITHDRAWAL, TRANSFER, RECEIVED, CASHBACK }

    private String transactionId;
    private Account account;
    private Type type;
    private long amount;
    private LocalDateTime createdAt;
    private Account counterParty;

    public boolean isSelf() {
        return counterParty == null;
    }
}