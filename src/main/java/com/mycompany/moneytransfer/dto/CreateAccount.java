package com.mycompany.moneytransfer.dto;

/**
 * Create Account Dto
 * @author pavel.shatrov
 */
public class CreateAccount {

    private int id;
    private double amount;

    public CreateAccount() {
    }

    public CreateAccount(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
