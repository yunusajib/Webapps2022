/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.jsf;

import com.webapps2022.entity.UserEntity;
import com.webapps2022.ejb.userService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Laptop
 */
@Named
@SessionScoped
public class loginBean implements Serializable{
private String email;
private String password;
private UserEntity currentUser = null;

 @EJB
 userService storage;

    public loginBean() {
    }

    public loginBean(String email, String password, userService storage) {
        this.email = email;
        this.password = password;
        this.storage = storage;
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

    public UserEntity getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserEntity currentUser) {
        this.currentUser = currentUser;
    }

    public userService getStorage() {
        return storage;
    }

    public void setStorage(userService storage) {
        this.storage = storage;
    }

    public String checkLogin() {
        String nextXhtmlFile = " ";
        currentUser= storage.authenticate(email, password);
    System.out.print("this are my" + currentUser);
        if (currentUser == null) {
              nextXhtmlFile = "LoginError";

        } else if (currentUser.getRole().equals("admin")){
                nextXhtmlFile = "/admins/AdminHistory"; 
        } else if (currentUser.getRole().equals("user")){
               nextXhtmlFile = "/users/RecordHistory";
        }
        return nextXhtmlFile;
    }
    public String signUp() {
        String nextXhtmlFile = "/createAccount";
        
        return nextXhtmlFile;
    }
   
    public void refreshUserDetails (){
     currentUser = storage.getUser(email);
}
}

