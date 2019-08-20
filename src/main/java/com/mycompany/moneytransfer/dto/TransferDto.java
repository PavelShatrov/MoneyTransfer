package com.mycompany.moneytransfer.dto;

/**
 * Transfer Dto
 *
 * @author pavel.shatrov
 */
public class TransferDto {
    private int fromAccount;
    private int toAccount;
    private double amount;

    public TransferDto() {
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
