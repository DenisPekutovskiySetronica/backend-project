package com.project.depi.service.impl;

import com.project.depi.dao.BookDao;
import com.project.depi.entity.Book;
import com.project.depi.service.AppBookshelfService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AppBookshelfServiceImpl implements AppBookshelfService {

    private final BookDao bookDao;

    public AppBookshelfServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public boolean addBook(Book book) {
        bookDao.save(book);
        return true;
    }

    @Override
    public List<Book> listBooks() {
        return bookDao.findAll();
    }

    @Override
    public void updateBook(Long id, Book book) {
        Optional<Book> bookFromDbOptional = bookDao.findById(id);
        if (bookFromDbOptional.isPresent()) {
            book.setId(id);
        }
        bookDao.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookDao.deleteById(id);
    }
}
