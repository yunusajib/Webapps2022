/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.ejb;

import com.webapps2022.entity.TransactionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Laptop
 */
@Stateless
public  class transactionServiceBean implements transactionService {

 @PersistenceContext 
 EntityManager em;

    public transactionServiceBean() {
    }

@Override
public List<TransactionEntity> getTransactionList(){
List <TransactionEntity> transactions = em.createNamedQuery("findAllTransactionEntity").getResultList();
 return transactions;
}
@Override
public void insertTransaction(String receiverEmail, String senderEmail, Double transactionAmount, String transactionCurrency){   
    TransactionEntity trns = new TransactionEntity (receiverEmail, senderEmail, transactionCurrency, transactionAmount);       
    em.persist(trns);
        System.out.println("Inserted the following in the transactione:");
        System.out.println("receiverEmail: " + receiverEmail);
        System.out.println("senderEmail: " + senderEmail);
        System.out.println("transactionCurrency: " + transactionCurrency);
        System.out.println("transactionAmount: " + transactionAmount);
       
        
}
@Override
public TransactionEntity authenticate(String email) {
    List <TransactionEntity> TransactionList = em.createNamedQuery("findUser",  TransactionEntity.class).setParameter("email", email).getResultList();
  if (TransactionList.isEmpty()){return null;}
    TransactionEntity firstUserFromList = TransactionList.get(0);
    return firstUserFromList;
}


@Override
public List<TransactionEntity> getUserTransactions(String userName){
List <TransactionEntity> transactions = em.createNamedQuery("findUserTransactions").setParameter("email", userName).getResultList();
 return transactions;
}
}