package org.gfg.minor1.repository;

import org.gfg.minor1.model.Author;
import org.gfg.minor1.model.Book;
import org.gfg.minor1.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByBookNo(String bookNo);
    List<Book> findByAuthorName(String authorName);
    List<Book> findByCost(int cost);
    List<Book> findByType(BookType bookType);
    List<Book> findByCostLessThan(int cost);
    List<Book> findByCostGreaterThan(int cost);


}
