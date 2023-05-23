package com.project.depi.mappers;

import com.project.depi.dto.BookDto;
import com.project.depi.entity.Book;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(config = MapStructDefaultConfig.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class BooksMapper {

    public abstract BookDto toBookDto(Book book);

    public abstract Book toBook(BookDto bookDto);
}
