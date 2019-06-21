package com.lambdaschool.javabookstore.controllers;

import com.lambdaschool.javabookstore.models.Book;
import com.lambdaschool.javabookstore.models.Quote;
import com.lambdaschool.javabookstore.services.DataService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    DataService dataService;

    @PreAuthorize("hasAuthority('ROLE_DATA')")
    @ApiOperation(value = "Updates a book associated with the book ID", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Book Found", response = Book.class),
            @ApiResponse(code = 404, message = "Book Not Found", response = ErrorDetail.class)})
    @PutMapping(value = "/books/{id}")
    public ResponseEntity<?> updateBook(HttpServletRequest request, @RequestBody Book updateBook, @PathVariable long id)
    {
        logger.trace(request.getRequestURI() + " accessed");

        dataService.update(updateBook, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_DATA')")
    @ApiOperation(value = "Assigns a book ID associated with the author ID", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Book Found", response = Book.class),
            @ApiResponse(code = 404, message = "Book Not Found", response = ErrorDetail.class)})
    @PostMapping(value = "/books/{bookid}/authors/{authorid}")
    public ResponseEntity<?> assignBookToAuthor(HttpServletRequest request, @PathVariable long bookid, @PathVariable long authorid) throws URISyntaxException
    {
        logger.trace(request.getRequestURI() + " accessed");

        dataService.save(bookid, authorid);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ROLE_DATA')")
    @ApiOperation(value = "Deletes a book associated with the book ID", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Book Found", response = Book.class),
            @ApiResponse(code = 404, message = "Book Not Found", response = ErrorDetail.class)})
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBookById(HttpServletRequest request, @PathVariable long id)
    {
        logger.trace(request.getRequestURI() + " accessed");

        dataService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
