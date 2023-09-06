/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.jsf;


import com.webapps2022.ejb.transactionService;
import com.webapps2022.ejb.userService;
import com.webapps2022.entity.TransactionEntity;
import com.webapps2022.entity.UserEntity;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Laptop
 */

@Named
@SessionScoped
public class adminHistoryBean implements Serializable{

@NotNull
List<UserEntity> allUsers;

@NotNull
List<TransactionEntity> allTransactions;
  
@EJB
userService userdb;
@EJB
transactionService transactiondb;
    public adminHistoryBean() {
    }
   
    public List<UserEntity> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<UserEntity> allUsers) {
        this.allUsers = allUsers;
    }

    public List<TransactionEntity> getAllTransactions() {
        return allTransactions;
    }

    public void setAllTransactions(List<TransactionEntity> allTransactions) {
        this.allTransactions = allTransactions;
    }


     public String viewAllUser() {
        allUsers= userdb.getUserList();
        return "AllUsers";
    }

    public String viewAllTransaction() {
       allTransactions = transactiondb.getTransactionList();
        return "AllTransactions";
}
   public String registerAdmin(String userName) {
       UserEntity user = userdb.getUser(userName);
        userdb.updateUserRole(user, "admin");
        return viewAllUser();
}
}

 

