/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.restservice;

import java.util.ArrayList;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Laptop
 */
@Singleton
@Path("currency")
public class CurrencyConversionAPI {

private CurrencyConverter converter = new CurrencyConverter();    

@GET
@Path("{senderCurrency}/{receiverCurrency}/{amount}")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Double getConvertedAmount(
 @PathParam("senderCurrency") String senderCurrency,
 @PathParam("receiverCurrency") String receiverCurrency,
 @PathParam("amount") Double amount ) {
        return converter.Convert(senderCurrency, receiverCurrency, amount);
    }

}
