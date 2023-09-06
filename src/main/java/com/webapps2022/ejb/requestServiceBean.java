/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.ejb;

import com.webapps2022.entity.requestEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Laptop
 */
@ Stateless
public class requestServiceBean implements requestService {
     @PersistenceContext 
     EntityManager em;

    public requestServiceBean() {
    }
@Override
public List<requestEntity> getRequestList(String user){
List <requestEntity> Request = em.createNamedQuery("findrequest").setParameter("requestedTo", user).getResultList();
 return Request;
}
@Override
public void insertUser(Double amount, String requestedFrom, String requestedTo){   
    requestEntity trns = new requestEntity (amount, requestedFrom, requestedTo);       
    em.persist(trns);
        System.out.println("Inserted the following in the transactione:");
       
        System.out.println("amount: " + amount);
    }
 @Override 
public void removeRequest(Long id)  {
  em.createNamedQuery("deleteRequest").setParameter("id", id).executeUpdate();
}   
//@Override
//public requestEntity authenticate(String email) {
//    List <requestEntity> requestList = em.createNamedQuery("findrequest",  requestEntity.class).setParameter("email", email).getResultList();
//  if (requestList.isEmpty()){return null;}
//    requestEntity firstrequestFromrequestList = requestList.get(0);
//    return firstrequestFromrequestList;
//}

}
