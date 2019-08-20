package com.mycompany.moneytransfer.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Account class
 * @author pavel.shatrov
 */
@Entity
public class Account implements Serializable {
    /** Account's id */
    @Id
    private int id;
    /** Account's amount */
    private double amount;
    /** Last operation status */
    private String status;
    
    public Account() {       
    }

    public Account(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public long getId() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", amount=" + amount + ", status=" + status + '}';
    }        
}
