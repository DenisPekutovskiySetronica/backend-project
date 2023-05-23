package com.project.depi.service;

import com.project.depi.dto.BookDto;
import com.project.depi.entity.Book;

public interface WebBookshelfService {

    String listAllBooks();

    Boolean addBook(BookDto book);

    void editBook(Long id, BookDto bookDto);

    void deleteById(Long id);
}
