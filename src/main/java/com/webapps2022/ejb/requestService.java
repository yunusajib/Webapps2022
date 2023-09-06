/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.ejb;

import com.webapps2022.entity.requestEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Laptop
 */
@Local
public interface  requestService {
    public List<requestEntity> getRequestList(String user);
    public void insertUser(Double amount, String requestedFrom, String requestedTo);
    public void removeRequest(Long id);

    //public requestEntity authenthicate(String email);

//    public requestEntity authenticate(String email);
    
}
