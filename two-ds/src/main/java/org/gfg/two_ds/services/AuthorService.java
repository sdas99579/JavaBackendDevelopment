package org.gfg.two_ds.services;

import org.gfg.two_ds.authorDB.Author;
import org.gfg.two_ds.authorDB.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public boolean addAuthor(Author author) {
        authorRepository.save(author);
        return true;
    }
}
