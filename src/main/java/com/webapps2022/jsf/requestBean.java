/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.jsf;

import com.webapps2022.ejb.userService;
import com.webapps2022.entity.UserEntity;
import com.webapps2022.ejb.requestService;
import com.webapps2022.entity.requestEntity;
import com.webapps2022.jsf.sendBean;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Laptop
 */
@Named
@SessionScoped

public class requestBean implements Serializable {
   private String requestedTo;
   private Double amount;
   private List<requestEntity> userRequests;
   //private requestEntity currentRequest = null;

    public List<requestEntity> getUserRequests() {
        return userRequests;
    }

    public void setUserRequests(List<requestEntity> userRequests) {
        this.userRequests = userRequests;
    }

@EJB
requestService requestService;
@EJB
userService userService;

@Inject
loginBean loginBean;
@Inject
sendBean sendBean;

    public requestBean() {
    }

    public String getRequestedTo() {
        return requestedTo;
    }

    public void setRequestedTo(String requestedTo) {
        this.requestedTo = requestedTo;
    }

    public requestService getRequestService() {
        return requestService;
    }

    public void setRequestService(requestService requestService) {
        this.requestService = requestService;
    }

    public sendBean getSendBean() {
        return sendBean;
    }

    public void setSendBean(sendBean sendBean) {
        this.sendBean = sendBean;
    }

   
    

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

 
    public loginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(loginBean loginBean) {
        this.loginBean = loginBean;
    }

 
    

public String request() {
 String requester = loginBean.getCurrentUser().getUsername(); 
 UserEntity requesteeUser = userService.getUser(requestedTo);
 if(requesteeUser !=null && (!loginBean.equals(requesteeUser))){ 
 requestService.insertUser(amount,requester, requestedTo);
       return "RequestSuccessful";
}
return "Unsuccessful";
}



public String Back(){
    return "RecordHistory";

}



public List<requestEntity> userRequest(){
userRequests = requestService.getRequestList(loginBean.getEmail());
return userRequests;
}

public String acceptedRequest(Long id, String receiver, double amount){
 sendBean.setAmountBeforeFx(amount);
 sendBean.setEmail(receiver);
 String transferOutcome = sendBean.send();
// 
if(transferOutcome.equals("SendSuccessful")){
 requestService.removeRequest(id);
 return "SendSuccessful";
}

return "Unsuccessful";
}

public String rejectedRequest(Long id){
 
 requestService.removeRequest(id);
 return "Notification";
}


}


  