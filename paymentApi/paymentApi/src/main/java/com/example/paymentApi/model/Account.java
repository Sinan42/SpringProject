package com.example.paymentApi.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountNumber;
    @Enumerated(EnumType.ORDINAL)
    private CURRENCY_CODE currencyCode;
    private String ownerName;
    @Enumerated(EnumType.ORDINAL)
    private ACCOUNT_TYPE account_type;
    private double balance;
}

