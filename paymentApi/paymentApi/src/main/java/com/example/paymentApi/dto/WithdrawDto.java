package com.example.paymentApi.dto;

import lombok.Data;

@Data
public class WithdrawDto {
    private Integer accountNumber;
    private double amount;
}
