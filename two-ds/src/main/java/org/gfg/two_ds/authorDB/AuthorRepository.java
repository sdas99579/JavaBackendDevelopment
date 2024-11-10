package org.gfg.two_ds.authorDB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
