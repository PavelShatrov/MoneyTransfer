package com.mycompany.moneytransfer;

import com.mycompany.moneytransfer.model.Account;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 * Handle Test
 * @author pavel.shatrov
 */
public class TransactionHandlerTest {
    public TransactionHandlerTest() {
    }
  
    /**
     * Test of handle method, of class TransactionHandler.
     */
    @Test
    public void testHandle() throws Exception {
        Account account1 = new Account(111, 500);
        Account account2 = new Account(333, 500);
        TransactionHandler instance = new TransactionHandler();
        boolean result = instance.processTransfer(account1, account2, 100);
        // Check for result
        assertEquals(true, result);
        // Check amount of the first account
        assertEquals(account1.getAmount(), 400.0);
        // Check the whole amount
        assertEquals(account1.getAmount() + account2.getAmount(), 1000.0);
    }    
}
