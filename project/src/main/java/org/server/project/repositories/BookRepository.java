package org.server.project.repositories;

import org.server.project.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  @Query("""
        SELECT b FROM Book b JOIN b.bookDetail d
        WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :q, '%'))
              OR LOWER(d.description) LIKE LOWER(CONCAT('%', :q, '%'))
        """)
  List<Book> searchByTitleOrDescription(@Param("q") String q);
}
