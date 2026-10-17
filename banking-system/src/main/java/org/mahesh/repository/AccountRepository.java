package org.mahesh.repository;

import org.mahesh.exception.AccountExistException;
import org.mahesh.exception.AccountNotFoundException;
import org.mahesh.model.Account;

import java.time.LocalDateTime;

public interface AccountRepository {
    Account createAccount(String accountId, LocalDateTime timestamp) throws AccountExistException;
    Account getAccount(String accountId) throws AccountNotFoundException;
}
