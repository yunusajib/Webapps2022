/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.jsf;

import com.webapps2022.restservice.CurrencyService;
import com.webapps2022.ejb.transactionService;
import com.webapps2022.ejb.userService;
import com.webapps2022.entity.UserEntity;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

/**
 *
 * @author Laptop
 */
@Named
@RequestScoped
public class sendBean{

    private String email;
    private Double amountBeforeFx;
    private Double amountAfterFx;
    
@EJB
transactionService transact;
@EJB
userService userService;
@Inject
loginBean loginBean;

    public sendBean() {
   
    }


   // public List<String> getCurrencyList() {
        //return currencyList;
    //}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getAmountBeforeFx() {
        return amountBeforeFx;
    }

    public void setAmountBeforeFx(Double amountBeforeFx) {
        this.amountBeforeFx = amountBeforeFx;
    }

  
 @Transactional
    public String send() {
        UserEntity sender = loginBean.getCurrentUser();

    if (checkSenderHasSufficentBalance(sender, amountBeforeFx)){
        UserEntity receiver = userService.getUser(email);
        if(receiver!=null && (!receiver.equals(sender))){
        amountAfterFx = convertAmountToReceiverCurrency(receiver, sender, amountBeforeFx);
        Double receiverNewBalance = receiver.getBalance() + amountAfterFx;
        updateSenderAccount(sender, amountBeforeFx);
        updateReceiverAccount(receiver, receiverNewBalance);
        recordTransaction(receiver.getUsername(), sender.getUsername(), amountAfterFx, receiver.getCurrency());
        return "SendSuccessful";
      }else return "Unsuccessful";
 }
return "InsufficientBalance";
}



 private void recordTransaction(String receiverEmail, String senderEmail ,Double transactionAmount, String transcationCurrency){
transact.insertTransaction(receiverEmail, senderEmail, transactionAmount, transcationCurrency );
}

private void updateSenderAccount(UserEntity sender, Double sentAmount) {
 Double senderNewBalance = sender.getBalance() - sentAmount;
 userService.updateUser(sender, senderNewBalance);
}

private Boolean checkSenderHasSufficentBalance(UserEntity sender, Double amount){

        return (sender.getBalance() - amount)>= 0.0;
}

private void updateReceiverAccount(UserEntity receiver, Double receiverNewBalance) {
 userService.updateUser(receiver, receiverNewBalance);
}

private Double convertAmountToReceiverCurrency (UserEntity receiver, UserEntity sender, Double amount) {
  CurrencyService convert = new CurrencyService();
  return convert.getCurrentFx(sender.getCurrency(), receiver.getCurrency(), amount);
}

public String Back(){
//String nextXhtmlFile = "history";
return "RecordHistory";

}

    
}
