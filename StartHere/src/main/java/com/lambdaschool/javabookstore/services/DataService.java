package com.lambdaschool.javabookstore.services;

import com.lambdaschool.javabookstore.models.Book;

public interface DataService
{
    Book update(Book book, long id);

    void save(Long bookid, Long authorid);

    void delete(long id);
}
