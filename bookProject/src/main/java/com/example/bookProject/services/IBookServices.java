package com.example.bookProject.services;


import com.example.bookProject.dto.RequestBookDto;
import com.example.bookProject.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public interface IBookServices {
    public RequestBookDto createBook(RequestBookDto requestBookDto);
    public List<Book> getAllBooks();
}
