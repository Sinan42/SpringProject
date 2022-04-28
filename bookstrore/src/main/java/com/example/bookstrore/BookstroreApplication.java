package com.example.bookstrore;

import com.example.bookstrore.model.Book;
import com.example.bookstrore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstroreApplication implements CommandLineRunner {
	private BookRepository bookRepository;

	public static void main(String[] args) {SpringApplication.run(BookstroreApplication.class, args);}


	@Override
	public void run(String... args) throws Exception {
		Book book1=Book.builder().
				name("Fareler ve Insanlar").
				author("Sinan Kaymak").
				price(55.0).stock(20).build();
		Book book2=Book.builder().
				name("Ortadoğu").
				author("Ahmet Kaymak").
				price(57.87).stock(20).build();
		Book book3=Book.builder().
				name("İspanyol dili ve Grameri").
				author("Inci kut").
				price(59.87).stock(20).build();
		bookRepository.saveAll(Arrays.asList(book1,book2,book3));

	}
}
