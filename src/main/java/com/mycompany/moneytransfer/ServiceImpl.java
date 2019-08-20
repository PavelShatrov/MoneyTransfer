package com.mycompany.moneytransfer;

import com.mycompany.moneytransfer.dto.CreateAccount;
import com.mycompany.moneytransfer.dto.TransferDto;
import com.mycompany.moneytransfer.model.Account;
import com.mycompany.moneytransfer.model.Transfer;
import com.mycompany.moneytransfer.repository.MoneyRepository;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.PathParam;

/**
 * ServiceImpl class
 * @author pavel.shatrov
 */
@Singleton
public class ServiceImpl {
    @Inject
    private MoneyRepository bankRepository;
    @Inject
    private TransactionPoller poller;    
    
    /**
     * Creates new account
     * @param account CreateAccount Dto
     * @return true when account created successfully
     */
    public boolean createAccount(CreateAccount account) {
        boolean result = false;
        try {
            bankRepository.createAccount(account.getId(), account.getAmount());
            result = true;
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            result = false;
        }        
        return result;
    }
    
    /**
     * Makes a transfer from one account(fromAccount) to another(toAccount)
     * @param transfer TransferDto
     */
    public void makeTransfer(TransferDto transfer) {
        try {
            poller.add(new Transfer(transfer.getFromAccount(), transfer.getToAccount(), transfer.getAmount()));
        } catch (InterruptedException ex) { 
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     * Returns account's details
     * @param id of an account
     * @return Account object
     */
    public Account getAccount(@PathParam("id") int id) {
        return bankRepository.getAccountById(id);
    }
}
