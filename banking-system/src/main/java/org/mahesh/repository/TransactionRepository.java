package org.mahesh.repository;

import org.mahesh.model.Transaction;

import java.time.LocalDateTime;
import java.util.TreeSet;

public interface TransactionRepository {
    boolean deposit(Transaction transaction);
    boolean withdraw(Transaction transaction);
    Transaction getTransaction(String transactionId);
    TreeSet<Transaction> getAllTransactions(LocalDateTime from, LocalDateTime to);
    TreeSet<Transaction> getAllTransactions(String accountId);
}