package com.project.depi.dao;

import com.project.depi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleIn(List<String> titles);
}
