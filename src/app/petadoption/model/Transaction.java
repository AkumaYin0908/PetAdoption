/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.petadoption.model;

import java.time.LocalDate;

public class Transaction {

    private int transId;
    private String customer;
    private int petId;
    private LocalDate date;
    private String transactionType;

    public Transaction() {
    }

    public Transaction(int transId, String customer, int petId, LocalDate date, String transactionType) {
        this.transId = transId;
        this.customer = customer;
        this.petId = petId;
        this.date = date;
        this.transactionType = transactionType;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    
    
}
