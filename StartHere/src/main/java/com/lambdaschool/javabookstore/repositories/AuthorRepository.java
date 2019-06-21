package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long>
{
}
