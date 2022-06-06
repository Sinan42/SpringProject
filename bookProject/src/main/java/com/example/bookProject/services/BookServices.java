package com.example.bookProject.services;

import com.example.bookProject.dto.RequestBookDto;
import com.example.bookProject.model.Book;
import com.example.bookProject.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices implements IBookServices{
    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;

    public BookServices(ModelMapper modelMapper, BookRepository bookRepository) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }



    @Override
    public RequestBookDto createBook(RequestBookDto requestBookDto) {
        Book book=modelMapper.map(requestBookDto,Book.class);
        book.setName(requestBookDto.getName());
        book.setDescription(requestBookDto.getDescription());

        return modelMapper.map(bookRepository.save(book),RequestBookDto.class);
    }

    @Override
    public List<Book> getAllBooks() {

       return bookRepository.findAll();
    }
}
