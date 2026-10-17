package org.mahesh.repository;

import org.mahesh.model.Transaction;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class InMemoryTransactionRepository implements TransactionRepository {

    private final TreeSet<Transaction> transactionTreeSet = new TreeSet<>(Comparator.comparing(Transaction::getCreatedAt));
    private final Map<String, Transaction> transactionMap = new HashMap<>();

    /**
     * @param transaction
     * @return
     */
    @Override
    public boolean deposit(Transaction transaction) {
        if (transactionMap.containsKey(transaction.getTransactionId())) {
            // throw exception
        }
        transactionTreeSet.add(transaction);
        transactionMap.put(transaction.getTransactionId(), transaction);

        return false;
    }

    /**
     * @param transaction
     * @return
     */
    @Override
    public boolean withdraw(Transaction transaction) {
        return false;
    }

    /**
     * @param transactionId
     * @return
     */
    @Override
    public Transaction getTransaction(String transactionId) {
        return null;
    }

    /**
     * @param from
     * @param to
     * @return
     */
    @Override
    public TreeSet<Transaction> getAllTransactions(LocalDateTime from, LocalDateTime to) {
        //transactionTreeSet.subSet()
        return null;
    }

    /**
     * @param accountId
     * @return
     */
    @Override
    public TreeSet<Transaction> getAllTransactions(String accountId) {
        return null;
    }
}
