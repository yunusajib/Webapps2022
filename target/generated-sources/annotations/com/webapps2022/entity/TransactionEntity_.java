package com.webapps2022.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-02-20T15:23:27")
@StaticMetamodel(TransactionEntity.class)
public class TransactionEntity_ { 

    public static volatile SingularAttribute<TransactionEntity, String> transactionCurrency;
    public static volatile SingularAttribute<TransactionEntity, String> senderEmail;
    public static volatile SingularAttribute<TransactionEntity, Double> transactionAmount;
    public static volatile SingularAttribute<TransactionEntity, Long> id;
    public static volatile SingularAttribute<TransactionEntity, String> receiverEmail;

}