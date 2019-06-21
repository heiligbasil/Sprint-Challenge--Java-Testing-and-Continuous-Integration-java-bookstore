package com.lambdaschool.javabookstore.services;

import com.lambdaschool.javabookstore.models.Author;

import java.util.List;

public interface AuthorService
{
    List<Author> findAll();
}
