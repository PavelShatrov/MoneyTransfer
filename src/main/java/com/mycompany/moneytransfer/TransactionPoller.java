package com.mycompany.moneytransfer;

import com.mycompany.moneytransfer.model.Transfer;
import com.mycompany.moneytransfer.repository.MoneyRepository;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Transaction Handler
 * @author pavel.shatrov
 */
@Singleton
@Startup
public class TransactionPoller {
    private final LinkedBlockingQueue<Transfer> queue = new LinkedBlockingQueue<>();
    private final AtomicBoolean stopFlag = new AtomicBoolean(false);    
    private TransactionHandler handler = new TransactionHandler();
    @Inject
    private MoneyRepository bankRepository;

    public TransactionPoller() {
        new Thread(new PollerRunner()).start();
    }    
    
    /**
     * Adds new transfer to the queue
     * @param transfer
     * @throws InterruptedException 
     */
    public void add(Transfer transfer) throws InterruptedException {
        queue.put(transfer);
    }
    
    public class PollerRunner implements Runnable {
        @Override
        public void run() {

            while (!stopFlag.get()) {
                try {
                    System.out.println("Check...");
                    Transfer transfer = queue.poll(10000, TimeUnit.MILLISECONDS);
                    if (transfer != null) {
                        System.out.println("Got transfer: " + transfer);
                        handler.handle(bankRepository, transfer);
                    }
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public void stop() {
        stopFlag.set(true);
    }
}
