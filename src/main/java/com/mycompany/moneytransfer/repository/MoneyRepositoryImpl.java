package com.mycompany.moneytransfer.repository;

import com.mycompany.moneytransfer.model.Account;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Repository Implementation
 * @author pavel.shatrov
 */
@Singleton
public class MoneyRepositoryImpl implements MoneyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createAccount(int id, double amount) {
        Account a = new Account(id, amount);
        entityManager.persist(a);
    }

    @Override
    public Account getAccountById(int id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }

}
