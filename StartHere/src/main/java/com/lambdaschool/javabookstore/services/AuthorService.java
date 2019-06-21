package com.lambdaschool.javabookstore.services;

import com.lambdaschool.javabookstore.models.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService
{
    List<Author> findAll(Pageable pageable);
}
