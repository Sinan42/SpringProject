package com.example.paymentApi.service;

import com.example.paymentApi.dto.*;
import com.example.paymentApi.model.ACCOUNT_TYPE;
import com.example.paymentApi.model.Account;
import com.example.paymentApi.model.TRANSACTION_TYPE;
import com.example.paymentApi.model.Transaction;
import com.example.paymentApi.repository.AccountRepository;
import com.example.paymentApi.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;




    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;

    }
    public AccountDto createAccount(AccountDto accountDto){

        

        Account account=modelMapper.map(accountDto,Account.class);
        Transaction transaction=new Transaction();
        transaction.setAccountNumber(accountDto.getAccountNumber());
        transactionRepository.save(transaction);

        account.setAccountNumber(accountDto.getAccountNumber());
        account.setCurrencyCode(accountDto.getCurrencyCode());
        account.setOwnerName(accountDto.getOwnerName());
        account.setAccount_type(accountDto.getAccount_type());


        return modelMapper.map(accountRepository.save(account),AccountDto.class);


    }
    public AccountInfoDto getAccountInfo(Integer id){
        return modelMapper.map(accountRepository.findById(id),AccountInfoDto.class);

    }
    public DepositDto loadDeposit(DepositDto depositDto){
        Account account = accountRepository.getById(depositDto.getAccountNumber());





        if (account.getAccount_type()== ACCOUNT_TYPE.INDIVIDUAL&&account.getBalance()>=0&&account.getBalance()>depositDto.getAmount()) {
            account.setBalance(account.getBalance() + depositDto.getAmount());
            depositDto.setAmount(depositDto.getAmount());
            accountRepository.save(account);
            Transaction transaction=transactionRepository.getById(depositDto.getAccountNumber());
            transaction.setTransactionType(TRANSACTION_TYPE.deposit);
            transaction.setAmount(depositDto.getAmount());
            transaction.setCreatedAt(LocalDateTime.now());
            transactionRepository.save(transaction);



            return modelMapper.map(accountRepository.save(account), DepositDto.class);
        }
        return modelMapper.map(accountRepository.save(account), DepositDto.class);


    }
    public WithdrawDto withdrawAmount(WithdrawDto withdrawDto){

        Account account = accountRepository.getById(withdrawDto.getAccountNumber());



        if(account.getAccount_type()==ACCOUNT_TYPE.INDIVIDUAL&&account.getBalance()>=withdrawDto.getAmount()&&withdrawDto.getAmount()>0){
            account.setBalance(account.getBalance()-withdrawDto.getAmount());
            withdrawDto.setAmount(withdrawDto.getAmount());
            accountRepository.save(account);
            Transaction transaction=transactionRepository.getById(account.getAccountNumber());
            transaction.setTransactionType(TRANSACTION_TYPE.withdraw);
            transaction.setAmount(withdrawDto.getAmount());
            transaction.setCreatedAt(LocalDateTime.now());
            transactionRepository.save(transaction);


        }
        return modelMapper.map(accountRepository.save(account),WithdrawDto.class);


    }
    public PaymentDto payment(PaymentDto paymentDto){
        Account accountSender=accountRepository.getById(paymentDto.getSenderAccount());
        Account accountReceiver=accountRepository.getById(paymentDto.getReceiverAccount());
        if(accountReceiver.getAccount_type()==ACCOUNT_TYPE.CORPORATE&&accountSender.getBalance()>=paymentDto.getAmount()){
            accountReceiver.setBalance(accountReceiver.getBalance()+paymentDto.getAmount());
            accountSender.setBalance(accountSender.getBalance()-paymentDto.getAmount());
            Transaction transaction=transactionRepository.getById(paymentDto.getSenderAccount());
            transaction.setTransactionType(TRANSACTION_TYPE.payment);
            transaction.setAmount(paymentDto.getAmount());
            transaction.setCreatedAt(LocalDateTime.now());
            transactionRepository.save(transaction);



            accountRepository.saveAll(Arrays.asList(accountReceiver,accountSender));
        }
        return modelMapper.map(accountRepository.saveAll(Arrays.asList(accountReceiver,accountSender)), PaymentDto.class);
    }




}
