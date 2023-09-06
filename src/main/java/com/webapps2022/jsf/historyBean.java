package com.webapps2022.jsf;


import com.webapps2022.ejb.transactionService;
import com.webapps2022.entity.TransactionEntity;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Laptop
 */
@Named
@SessionScoped
public class historyBean implements Serializable {
     private String email;
     private String amount;
     private List<TransactionEntity> userTransactions;

@Inject
loginBean login;

@EJB
private transactionService transactionService;


  public historyBean() {
    }

    public loginBean getLogin() {
        return login;
    }

    public void setLogin(loginBean login) {
        this.login = login;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
   
   public transactionService getTransactionService() {
        return transactionService;
    }

    public void setTransactionService(transactionService transactionService) {
        this.transactionService = transactionService;
    }

  

 
     public String makePayment() {
        //String nextXhtmlFile = "sendAmount";
        
        return "sendAmount";
    }
    public String makeRequest() {
        //String nextXhtmlFile = "requestAmount";
        
        return "requestAmount";
}
  public String notification() {
        //String nextXhtmlFile = "Notification";
        
        return "Notification";
}

public List<TransactionEntity> getUserTransactions(){
String user = login.getEmail();
userTransactions = transactionService.getUserTransactions(user);
return userTransactions;}


public String getTransactionType (String sender){

if(login.getEmail().equals(sender))
return "SENT";

else
return "RECIEVED";

} }


