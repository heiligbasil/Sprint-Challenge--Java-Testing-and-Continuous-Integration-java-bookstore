package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface DataRepository extends CrudRepository<Book, Long>
{
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO wrote(bookid, authoridi) values (:bookid, :authorid)", nativeQuery = true)
    void insertWrote(long bookid, long authorid);
}
