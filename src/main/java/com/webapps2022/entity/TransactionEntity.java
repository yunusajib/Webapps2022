/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Laptop
 */

@NamedQuery(name="findAllTransactionEntity", query="SELECT c FROM TransactionEntity c ")
@NamedQuery(name="findUserTransactions", query="SELECT u FROM TransactionEntity u  WHERE u.receiverEmail = :email OR u.senderEmail = :email")
@Entity
public class TransactionEntity implements Serializable {

@Id    
@GeneratedValue(strategy = GenerationType.AUTO) // GenerationType: TABLE, SEQUENCE, IDENTITY or AUTO
    private Long id;
    @NotNull
    String receiverEmail;

    @NotNull
    String senderEmail;

    @NotNull
    String transactionCurrency;
    

    @NotNull
     Double transactionAmount;
    
  public TransactionEntity(String receiverEmail, String senderEmail, String transactionCurrency, Double transactionAmount) {
        this.receiverEmail = receiverEmail;
        this.senderEmail = senderEmail;
        this.transactionCurrency = transactionCurrency;
        this.transactionAmount = transactionAmount;
    }

    public TransactionEntity() {
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Long getId() {
        return id;
    }
   

@Override
    public int hashCode() {
        int hash = 8;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.receiverEmail);
        hash = 13 * hash + Objects.hashCode(this.senderEmail);
        hash = 13 * hash + Objects.hashCode(this.transactionCurrency);
        hash = 13 * hash + Objects.hashCode(this.transactionAmount);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransactionEntity other = (TransactionEntity) obj;
        if (!Objects.equals(this.receiverEmail, other.receiverEmail)) {
            return false;
        }
        if (!Objects.equals(this.senderEmail, other.senderEmail)) {
            return false;
        }
        if (!Objects.equals(this.transactionCurrency, other.transactionCurrency)) {
            return false;
        }
        if (!Objects.equals(this.transactionAmount, other.transactionAmount)) {
            return false;
        }
 
        return Objects.equals(this.id, other.id);
    }
}

