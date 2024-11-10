package org.gfg.minor1.repository;

import org.gfg.minor1.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    //1st way of writing query this will not taking care by hibernate
    @Query(value = "select * from author where email=:email", nativeQuery = true) //mysql
    Author getAuthor(String email);


    //2nd way  for one single parameter no need to write as value
    @Query("select a from Author a where a.email=:email") //hibernate
    Author getAuthorWithoutNative(String email);

    //3rd way of writing query

    Author findByEmail(String email);

}
