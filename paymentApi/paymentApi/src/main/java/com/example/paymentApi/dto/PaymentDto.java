package com.example.paymentApi.dto;

import lombok.Data;

@Data
public class PaymentDto {
    private Integer senderAccount;
    private Integer receiverAccount;
    private double  amount;
}
