package com.example.paymentApi.dto;

import com.example.paymentApi.model.ACCOUNT_TYPE;
import com.example.paymentApi.model.CURRENCY_CODE;
import com.example.paymentApi.model.TRANSACTION_TYPE;
import com.example.paymentApi.model.Transaction;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
public class TransactionDto {
    private Integer accountNumber;
    private double  amount;
    private TRANSACTION_TYPE transactionType;
    private LocalDateTime createdAt;
}
