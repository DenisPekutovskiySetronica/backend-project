package com.project.depi.service.impl;

import com.google.gson.Gson;
import com.project.depi.dto.BookDto;
import com.project.depi.entity.Book;
import com.project.depi.mappers.BooksMapper;
import com.project.depi.service.AppBookshelfService;
import com.project.depi.service.WebBookshelfService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebBookshelfServiceImpl implements WebBookshelfService {

    private final AppBookshelfService appBookshelfService;
    private final BooksMapper booksMapper;
    private static final Gson GSON = new Gson();

    public WebBookshelfServiceImpl(AppBookshelfService appBookshelfService, BooksMapper booksMapper) {
        this.appBookshelfService = appBookshelfService;
        this.booksMapper = booksMapper;
    }

    @Override
    public String listAllBooks() {
        List<Book> books = appBookshelfService.listBooks();
        List<BookDto> bookDtoList = books.stream()
                .map(booksMapper::toBookDto)
                .collect(Collectors.toList());
        return GSON.toJson(bookDtoList);
    }

    @Override
    public Boolean addBook(BookDto bookDto) {
        return appBookshelfService.addBook(booksMapper.toBook(bookDto));
    }

    @Override
    public void editBook(Long id, BookDto bookDto) {
        Book book = booksMapper.toBook(bookDto);
        appBookshelfService.updateBook(id, book);
    }

    @Override
    public void deleteById(Long id) {
        appBookshelfService.deleteBook(id);
    }
}
