package com.lambdaschool.javabookstore.services;

import com.lambdaschool.javabookstore.models.Book;
import com.lambdaschool.javabookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookrepo;

    @Override
    public List<Book> findAll()
    {
        List<Book> list = new ArrayList<>();
        bookrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
