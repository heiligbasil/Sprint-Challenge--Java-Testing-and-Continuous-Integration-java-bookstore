package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>
{
}
