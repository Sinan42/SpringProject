package com.example.bookProject.controller;

import com.example.bookProject.dto.RequestBookDto;
import com.example.bookProject.model.Book;
import com.example.bookProject.services.BookServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
public class BookController {
    private final BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }


    @PostMapping("/books")
    public ResponseEntity<RequestBookDto> createAccount(@RequestBody RequestBookDto requestBookDto){
        RequestBookDto request=bookServices.createBook(requestBookDto);
        return ResponseEntity.ok(request);
    }
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookServices.getAllBooks();

    }
}
