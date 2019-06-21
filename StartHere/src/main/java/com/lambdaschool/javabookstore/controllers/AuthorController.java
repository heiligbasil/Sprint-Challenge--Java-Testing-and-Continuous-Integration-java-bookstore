package com.lambdaschool.javabookstore.controllers;

import com.lambdaschool.javabookstore.models.Author;
import com.lambdaschool.javabookstore.services.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    AuthorService authorService;

    //@PreAuthorize("hasAuthority('ROLE_USERS')")
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> listAllQuotes(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");

        List<Author> allBooks = authorService.findAll();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }
}
