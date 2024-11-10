package org.gfg.JBDL_64_DBConnectivity.repositories;

import org.gfg.JBDL_64_DBConnectivity.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorJPARepository extends JpaRepository<Author,Integer> {
}
