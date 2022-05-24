package com.example.paymentsystem.dto;

import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.model.Transaction;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AccountDto {
    private String id;
    private BigDecimal balance;
    private LocalDateTime creationDate;
    private AccountCustomerDto customer;
    private List<TransactionDto> transactions;




}
