package com.example.paymentsystem.dto;

import com.example.paymentsystem.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class AccountCustomerDto {
    private String id;
    private BigDecimal balance;
    private List<Transaction> transactions;
    private LocalDateTime creationDate;

    public AccountCustomerDto(String id, String name, String surname, String surname1) {
    }
}
