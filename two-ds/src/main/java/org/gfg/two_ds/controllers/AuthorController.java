package org.gfg.two_ds.controllers;

import org.gfg.two_ds.authorDB.Author;
import org.gfg.two_ds.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;


    @PostMapping("/addAuthor")
    public boolean insertData(@RequestBody Author author) throws Exception {

        return authorService.addAuthor(author);
    }
}
