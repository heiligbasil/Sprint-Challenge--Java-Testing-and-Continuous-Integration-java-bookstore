package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>
{
}
