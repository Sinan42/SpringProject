package com.example.paymentApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")

public class Transaction {
    @Id
    @GeneratedValue
    private Integer accountNumber;
    private double  amount;
    private TRANSACTION_TYPE transactionType;
    private LocalDateTime createdAt;
}
