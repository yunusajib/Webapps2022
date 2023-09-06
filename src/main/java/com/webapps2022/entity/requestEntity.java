
package com.webapps2022.entity;

import java.io.Serializable;
import java.util.Objects;
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
@NamedQuery(name="findAllrequestEntity", query="SELECT c FROM requestEntity c ")
@NamedQuery(name="findrequest", query="SELECT u FROM requestEntity u  WHERE u.requestedTo = :requestedTo ")
@NamedQuery(name="deleteRequest", query="DELETE FROM requestEntity u WHERE u.id = :id")

@Entity
public class requestEntity implements Serializable {

@Id    
@GeneratedValue(strategy = GenerationType.AUTO) // GenerationType: TABLE, SEQUENCE, IDENTITY or AUTO
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 
    @NotNull
    Double amount;
    
    @NotNull
    String requestFrom;

    @NotNull
    String requestedTo;
//
//    public requestEntity() {
//    }

    public requestEntity() {
    }
    

    public requestEntity(Double amount, String requestFrom, String requestedTo) {
        this.amount = amount;
        this.requestFrom = requestFrom;
        this.requestedTo = requestedTo;
    }

   
   

//    public requestEntity(String email, SingularAttribute<requestEntity, Double> amount) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

//    public requestEntity(String email, String amount) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRequestFrom() {
        return requestFrom;
    }

    public void setRequestFrom(String requestFrom) {
        this.requestFrom = requestFrom;
    }

    public String getRequestedTo() {
        return requestedTo;
    }

    public void setRequestedTo(String requestedBy) {
        this.requestedTo = requestedBy;
    }


//    public requestEntity(String email, Double amount) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

@Override
public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
     
        hash = 13 * hash + Objects.hashCode(this.amount);
         hash = 13 * hash + Objects.hashCode(this.getRequestFrom());
        hash = 13 * hash + Objects.hashCode(this.requestedTo);
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
        final requestEntity other = (requestEntity) obj;
       
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }

        if (!Objects.equals(this.requestFrom, other.requestFrom)) {
            return false;
        }
        if (!Objects.equals(this.requestedTo, other.requestedTo)) {
            return false;
        }
      
        return Objects.equals(this.id, other.id);
    }
    
}
