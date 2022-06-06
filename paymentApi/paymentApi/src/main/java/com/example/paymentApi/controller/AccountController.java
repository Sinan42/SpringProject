package com.example.paymentApi.controller;

import com.example.paymentApi.dto.*;
import com.example.paymentApi.repository.AccountRepository;
import com.example.paymentApi.repository.TransactionRepository;
import com.example.paymentApi.service.AccountService;
import com.example.paymentApi.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/account")
public class AccountController {
    private AccountService accountService = null;
    private TransactionService transactionService=null;
    private final TransactionRepository transactionRepository;




    public AccountController(AccountService accountService, TransactionService transactionService, TransactionRepository transactionRepository) {
        this.accountService = accountService;

        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;

    }

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        AccountDto request=accountService.createAccount(accountDto);
        return ResponseEntity.ok(request);
    }
    @GetMapping("getById/{accountNumber}")
    public AccountInfoDto getAccount(@PathVariable("accountNumber") Integer accountNumber){
        AccountInfoDto accountInfoDto=accountService.getAccountInfo(accountNumber);
        return accountInfoDto;
    }
    @PostMapping("/deposit")
    public String getDeposit(@RequestBody DepositDto depositDto){
        DepositDto request=accountService.loadDeposit(depositDto);

            return "Transaction Successful";

        }

    @PostMapping("/withdraw")
    public String getWithdraw(@RequestBody WithdrawDto withdrawDto){
        WithdrawDto request=accountService.withdrawAmount(withdrawDto);

        return "Transaction Successful";
    }
    @PostMapping("/payment")
    public String payment(@RequestBody PaymentDto paymentDto){
        PaymentDto request=accountService.payment(paymentDto);
        return "Transaction Successful";
    }
    @GetMapping("/accounting/{id}")
    public TransactionDto getTransaction(@PathVariable("id") Integer id){
        TransactionDto response=transactionService.getTransactionById(id);
        return response;
    }





}
