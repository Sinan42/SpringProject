package com.example.paymentApi.service;

import com.example.paymentApi.dto.TransactionDto;
import com.example.paymentApi.model.Transaction;
import com.example.paymentApi.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionService {
    private final ModelMapper modelMapper;
    private final TransactionRepository transactionRepository;

    public TransactionService(ModelMapper modelMapper, TransactionRepository transactionRepository) {
        this.modelMapper = modelMapper;
        this.transactionRepository = transactionRepository;
    }

    public TransactionDto getTransactionById(Integer id){
        return modelMapper.map(transactionRepository.findById(id),TransactionDto.class);
    }

}

