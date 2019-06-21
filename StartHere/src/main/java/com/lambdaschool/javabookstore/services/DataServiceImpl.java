package com.lambdaschool.javabookstore.services;

import com.lambdaschool.javabookstore.models.Author;
import com.lambdaschool.javabookstore.models.Book;
import com.lambdaschool.javabookstore.repositories.AuthorRepository;
import com.lambdaschool.javabookstore.repositories.BookRepository;
import com.lambdaschool.javabookstore.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service(value = "dataService")
public class DataServiceImpl implements DataService
{
    @Autowired
    private BookRepository bookrepo;

    @Autowired
    private AuthorRepository authorrepo;

    @Autowired
    private DataRepository datarepo;

    @Override
    public Book update(Book book, long id)
    {
        Book currentBook = bookrepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (book.getBooktitle() != null)
        {
            currentBook.setBooktitle(book.getBooktitle());
        }

        if (book.getIsbn() != null)
        {
            currentBook.setIsbn(book.getIsbn());
        }

        if (book.getCopy() > 0)
        {
            currentBook.setCopy(book.getCopy());
        }

        return bookrepo.save(currentBook);
    }

    @Transactional
    @Override
    public void save(Long bookid, Long authorid)
    {
//        Book currentBook = bookrepo.findById(bookid).orElseThrow(() -> new EntityNotFoundException(Long.toString(bookid)));
//        Author currentAuthor = authorrepo.findById(authorid).orElseThrow(() -> new EntityNotFoundException(Long.toString(authorid)));
        datarepo.insertWrote(bookid,authorid);
    }

    @Override
    public void delete(long id)
    {
        if (bookrepo.findById(id).isPresent())
        {
            bookrepo.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }
}
