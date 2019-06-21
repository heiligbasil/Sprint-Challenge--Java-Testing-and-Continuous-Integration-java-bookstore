package com.lambdaschool.javabookstore.controllers;

import com.lambdaschool.javabookstore.models.Book;
import com.lambdaschool.javabookstore.services.BookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    BookService bookService;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @ApiOperation(value = "Return all books", response = Book.class, responseContainer = "List")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). " + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks(HttpServletRequest request, Pageable pageable)
    {
        logger.trace(request.getRequestURI() + " accessed");

        List<Book> allBooks = bookService.findAll(pageable);
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }
}
