package org.mahesh.repository;

import org.mahesh.exception.AccountExistException;
import org.mahesh.exception.AccountNotFoundException;
import org.mahesh.model.Account;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {

    private final Map<String, Account> accountMap = new HashMap<>();

    /**
     * @param accountId
     * @param timestamp
     * @return
     */
    @Override
    public Account createAccount(String accountId, LocalDateTime timestamp) throws AccountExistException {
        if (accountMap.containsKey(accountId)) {
            throw new AccountExistException("Account already exist");
        }
        Account account = new Account(accountId, timestamp);
        accountMap.put(accountId, account);
        return account;
    }

    @Override
    public Account getAccount(String accountId) throws AccountNotFoundException {
        if (accountMap.containsKey(accountId)) {
            return accountMap.get(accountId);
        }
        throw new AccountNotFoundException("Account not found");
    }
}