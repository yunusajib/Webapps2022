/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Laptop
 */
@Named
@RequestScoped
public class successfulBean {

@Inject
loginBean login;

 public String addTransaction() {
        login.refreshUserDetails();
        String nextXhtmlFile = "RecordHistory";
        return nextXhtmlFile;
    }
public String logout (){
        String nextXhtmlFile = "/index";
        return nextXhtmlFile;
    }
}
