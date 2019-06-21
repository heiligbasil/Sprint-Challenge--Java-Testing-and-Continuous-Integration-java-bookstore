package com.lambdaschool.javabookstore.services;

import com.lambdaschool.javabookstore.models.Author;
import com.lambdaschool.javabookstore.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private AuthorRepository authorrepo;

    @Override
    public List<Author> findAll(Pageable pageable)
    {
        List<Author> list = new ArrayList<>();
        authorrepo.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }
}
