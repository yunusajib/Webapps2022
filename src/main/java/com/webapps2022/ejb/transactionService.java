/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.ejb;

import com.webapps2022.entity.TransactionEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Laptop
 */
@Local
public interface transactionService {
    
    public List<TransactionEntity> getTransactionList();
    public TransactionEntity authenticate(String email);
    public void insertTransaction(String receiverEmail, String senderEmail, Double transactionAmount, String transactionCurrency);
    public List<TransactionEntity> getUserTransactions(String userName);
}
