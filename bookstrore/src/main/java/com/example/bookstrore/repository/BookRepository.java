package com.example.bookstrore.repository;

import com.example.bookstrore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {



}
