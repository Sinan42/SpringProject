package com.example.paymentApi.dto;

import lombok.Data;

@Data
public class DepositDto {
    private Integer accountNumber;
    private double amount;
}
