/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.restservice;

import com.webapps2022.restservice.CurrencyConverter;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Laptop
 */
public class CurrencyService {

    public CurrencyService() {
    }
    
 /**
    * This helper method creates an HTTP client that consumes the rest service
     * @return 
    */
  
 public Double getCurrentFx(String currency1, String currency2, Double amount) {
        Client client = ClientBuilder.newClient();
        WebTarget conversionResource = client.target("http://localhost:10000/Webapps2022/conversion/currency").path("{senderCurrency}")
                .resolveTemplate("senderCurrency", currency1)
                .path("{receiverCurrency}")
                .resolveTemplate("receiverCurrency", currency2)
                .path("{amount}")
                .resolveTemplate("amount", amount);
        Invocation.Builder builder = conversionResource.request(MediaType.APPLICATION_JSON);
        Double response = builder.get(Double.class);
        client.close();
        return response;
    }
}
