package com.example.paymentApi.dto;

import com.example.paymentApi.model.ACCOUNT_TYPE;
import com.example.paymentApi.model.CURRENCY_CODE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AccountDto {
    private Integer accountNumber;
    private CURRENCY_CODE currencyCode;
    private String ownerName;
    private ACCOUNT_TYPE account_type;
}
