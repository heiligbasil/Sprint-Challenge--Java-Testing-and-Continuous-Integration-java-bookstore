package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>
{
}
