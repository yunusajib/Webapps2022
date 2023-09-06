/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.restservice;

/**
 *
 * @author Laptop
 */
public class CurrencyConverter {

Double convertedAmount = 0.0;  

    public CurrencyConverter() {}

    public Double Convert(String senderCurrency, String receiverCurrency, Double amount){

      if(senderCurrency.equals("GBP")&&receiverCurrency.equals("USD")){
         convertedAmount =  amount*1.31;
      return convertedAmount;

}else if (senderCurrency.equals("GBP")&&receiverCurrency.equals("EUR")){
        convertedAmount =  amount*1.21;
      return convertedAmount;

}else if (senderCurrency.equals("USD")&&receiverCurrency.equals("GBP")){
        convertedAmount =  amount*0.76;
      return convertedAmount;
} else if (senderCurrency.equals("USD")&&receiverCurrency.equals("EUR")){
       convertedAmount =  amount*0.92;
      return convertedAmount;
} else if (senderCurrency.equals("EUR")&&receiverCurrency.equals("GBP")){
       convertedAmount =  amount*0.83;
      return convertedAmount;
} else if (senderCurrency.equals("EUR")&&receiverCurrency.equals("USD")) {
     convertedAmount =  amount*1.08;
      return convertedAmount;
}
else if (senderCurrency.equals("USD")&&receiverCurrency.equals("USD")){
       convertedAmount =  amount;
      return convertedAmount;
} else if (senderCurrency.equals("GBP")&&receiverCurrency.equals("GBP")){
       convertedAmount =  amount;
      return convertedAmount;
} else if (senderCurrency.equals("EUR")&&receiverCurrency.equals("EUR")) {
     convertedAmount =  amount;
      return convertedAmount;
}
return 0.0;
}
   
   
}
