package com.example.paymentApi;

import com.example.paymentApi.model.ACCOUNT_TYPE;
import com.example.paymentApi.model.Account;
import com.example.paymentApi.model.CURRENCY_CODE;
import org.hibernate.type.CurrencyType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Currency;

@SpringBootApplication
public class PaymentApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {





	}
}
