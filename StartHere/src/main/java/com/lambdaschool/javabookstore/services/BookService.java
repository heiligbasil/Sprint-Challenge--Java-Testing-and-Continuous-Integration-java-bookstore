package com.lambdaschool.javabookstore.services;

import com.lambdaschool.javabookstore.models.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService
{
    List<Book> findAll(Pageable pageable);
}
