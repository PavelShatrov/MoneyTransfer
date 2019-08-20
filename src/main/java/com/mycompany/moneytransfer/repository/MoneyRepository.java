package com.mycompany.moneytransfer.repository;

import com.mycompany.moneytransfer.model.Account;

/**
 * Repository interface
 * @author pavel.shatrov
 */
public interface MoneyRepository {
    public void createAccount(int id, double amount);
    public Account getAccountById(int id);
    public void updateAccount(Account account);
}
