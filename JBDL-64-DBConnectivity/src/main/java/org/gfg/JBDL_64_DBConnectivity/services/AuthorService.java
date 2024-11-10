package org.gfg.JBDL_64_DBConnectivity.services;

import org.gfg.JBDL_64_DBConnectivity.model.Author;
import org.gfg.JBDL_64_DBConnectivity.repositories.AuthorJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorJPARepository authorJPARepository;

    public boolean addAuthod(Author author) {
        authorJPARepository.save(author);
        return true;
    }
}
