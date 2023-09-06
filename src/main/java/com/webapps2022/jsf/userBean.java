package com.webapps2022.jsf;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.webapps2022.ejb.transactionService;
import com.webapps2022.ejb.userService;
import com.webapps2022.entity.TransactionEntity;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Laptop
 */
@Named
@SessionScoped
public class userBean implements Serializable {
 private String fname;
 private String lname;
 private String currency;
 private String email;
 private String password;
 private double balance;
 private String role;

@EJB
userService storage;


    public userBean() {
    }
 
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    


public String mySubmit() {
         System.out.println("This is the currency" + currency);
       storage.insertUsers(fname,lname, currency, email, password, balance, role);
   return "index";
    }
 

 
}
