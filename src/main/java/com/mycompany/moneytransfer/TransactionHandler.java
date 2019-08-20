package com.mycompany.moneytransfer;

import com.mycompany.moneytransfer.model.Account;
import com.mycompany.moneytransfer.model.Transfer;
import com.mycompany.moneytransfer.repository.MoneyRepository;

/**
 * Transaction Handler
 * @author pavel.shatrov
 */
public class TransactionHandler {
    private final String OK_STATUS = "The last operation was successful";
    private final String ERROR_STATUS = "Insufficient balance for amount: ";
    
    /**
     * Handles a transaction
     * @param bankRepository main repository
     * @param transfer transfer object
     */
    public void handle(MoneyRepository bankRepository, Transfer transfer) {
        Account fromAccount = bankRepository.getAccountById(transfer.getFromAccount());
        Account toAccount = bankRepository.getAccountById(transfer.getToAccount());
        if(processTransfer(fromAccount, toAccount, transfer.getAmount())) {
            toAccount.setStatus(OK_STATUS);
            fromAccount.setStatus(OK_STATUS);
            bankRepository.updateAccount(toAccount);
            bankRepository.updateAccount(fromAccount);
            System.out.println("Transfer was made from: " + transfer.getFromAccount() + " to: " + transfer.getToAccount() + " of ammount: " + transfer.getAmount());     
        } else {
            fromAccount.setStatus(ERROR_STATUS + transfer.getAmount());
            bankRepository.updateAccount(fromAccount);
            System.out.println("Cannot make transfer with ammount: " + transfer.getAmount());     
        }            
    }
    
    /**
     * The main logic of the transfer process
     * @param fromAccount from account
     * @param toAccount to account
     * @param amount
     * @return result of an operation. True in case of success
     */
    protected boolean processTransfer(Account fromAccount, Account toAccount, double amount) {
        if(amount > fromAccount.getAmount()) {            
            return false;
        }
        fromAccount.setAmount(fromAccount.getAmount() - amount);
        toAccount.setAmount(toAccount.getAmount() + amount);
        return true;
    }
 }
