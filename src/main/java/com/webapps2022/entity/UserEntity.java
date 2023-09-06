/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.enterprise.context.Dependent;
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
@NamedQuery(name="findAllUsers", query="SELECT c FROM UserEntity c WHERE c.role =:role") 
@NamedQuery(name="UpdateUserEntityBalance", query="UPDATE UserEntity c SET c.balance =:amount WHERE c.email =:email")
@NamedQuery(name="findUserEntity", query="SELECT c FROM UserEntity c WHERE c.email =:email")
@NamedQuery(name="findUser", query="SELECT u FROM UserEntity u  WHERE u.email = :email AND u.password = :password")
@Entity
@Dependent
public class UserEntity implements Serializable  {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO) // GenerationType: TABLE, SEQUENCE, IDENTITY or AUTO
   private Long id;
    @NotNull
    String fname;

    @NotNull
    String lname;

    @NotNull
    String currency;

    @NotNull
    String email;
   
    @NotNull
    String password;  

    @NotNull
    Double balance; 

    @NotNull
    String role; 
    


    public UserEntity() {
    }

   
    public UserEntity( String fname, String lname, String currency, String email, String password, Double balance, String role) {
        
        this.fname = fname;
        this.lname = lname;
        this.currency = currency;
        this.email = email;
        this.password = password;
        this.balance= balance;
        this.role = role;
    }


    public UserEntity(String fname, String lname, String currency, String email, String password, Double balance) {

    }

    public Long getId() {
        return id;
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


    public String getUsername() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



@Override
    public int hashCode() {
        int hash = 8;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.fname);
        hash = 13 * hash + Objects.hashCode(this.lname);
        hash = 13 * hash + Objects.hashCode(this.currency);
        hash = 13 * hash + Objects.hashCode(this.password);
        hash = 13 * hash + Objects.hashCode(this.balance);
        hash = 13 * hash + Objects.hashCode(this.role);
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
        final UserEntity other = (UserEntity) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.fname, other.fname)) {
            return false;
        }
        if (!Objects.equals(this.lname, other.lname)) {
            return false;
        }
        if (!Objects.equals(this.currency, other.currency)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.balance, other.balance)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}
