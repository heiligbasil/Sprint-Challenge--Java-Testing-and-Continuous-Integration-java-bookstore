package com.lambdaschool.javabookstore.services;

import com.lambdaschool.javabookstore.models.Book;

import java.util.List;

public interface BookService
{
    List<Book> findAll();
}
