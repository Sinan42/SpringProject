package com.example.paymentsystem.dto.converter;

import com.example.paymentsystem.dto.AccountCustomerDto;
import com.example.paymentsystem.dto.CustomerAccountDto;
import com.example.paymentsystem.model.Customer;

import java.util.Optional;

public class AccountDtoConverter {
    private final CustomerAccountDto customerAccountDto;

    public AccountDtoConverter(CustomerAccountDto customerAccountDto) {
        this.customerAccountDto = customerAccountDto;
    }
    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> from){
        return from.map(f->new AccountCustomerDto(f.getId(),f.getName(),f.getSurname(),f.getSurname())).orElse(null);
    }
}
