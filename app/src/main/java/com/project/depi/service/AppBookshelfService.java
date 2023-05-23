package com.project.depi.service;

import com.project.depi.entity.Book;

import java.util.List;

public interface AppBookshelfService {

    /**
     * Create book
     */
    boolean addBook(Book book);

    List<Book> listBooks();

    void updateBook(Long id, Book book);

    void deleteBook(Long id);
}
