package com.example.paymentsystem.repository;

import com.example.paymentsystem.model.Account;
import com.example.paymentsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
}
