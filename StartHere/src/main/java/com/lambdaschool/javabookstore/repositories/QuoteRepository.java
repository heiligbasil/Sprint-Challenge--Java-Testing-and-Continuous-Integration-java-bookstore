package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long>
{

}
