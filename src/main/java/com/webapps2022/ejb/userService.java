/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.ejb;

import com.webapps2022.entity.UserEntity;
//import com.webapps2022.entity.requestEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Laptop
 */
@Local
public interface userService {

    public List<UserEntity> getUserList();
    public UserEntity authenticate(String email, String password);
    public void updateUser(UserEntity user, double amount);
    public UserEntity getUser(String email);
    public void updateUserRole(UserEntity user, String role);    
public void insertUsers(String email, String fname, String lname,  String password,String currency, double balance, String role);
}
