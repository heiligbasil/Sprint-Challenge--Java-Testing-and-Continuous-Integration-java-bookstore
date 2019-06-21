package com.lambdaschool.javabookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book extends Auditable
{
    @ApiModelProperty(name = "bookid", value = "Primary key for Book", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @ApiModelProperty(name = "booktitle", value = "Book Title", required = true, example = "Some Name")
    @Column(nullable = false, unique = true)
    private String booktitle;

    @ApiModelProperty(name = "isbn", value = "ISBN", required = true, example = "1234567890123")
    @Column(nullable = false, unique = true)
    private String isbn;

    @ApiModelProperty(name = "copy", value = "Year Printed", required = true, example = "2001")
    @Column(nullable = false)
    private int copy;

    @ApiModelProperty(name = "authors", value = "List of Authors", required = true, example = "Some Name")
    @ManyToMany
    @JsonIgnoreProperties("books")
    private List<Author> authors = new ArrayList<>();

    public Book()
    {
    }

    public Book(String isbn, int copy)
    {
        this.isbn = isbn;
        this.copy = copy;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getBooktitle()
    {
        return booktitle;
    }

    public void setBooktitle(String booktitle)
    {
        this.booktitle = booktitle;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public int getCopy()
    {
        return copy;
    }

    public void setCopy(int copy)
    {
        this.copy = copy;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Author> authors)
    {
        this.authors = authors;
    }
}
