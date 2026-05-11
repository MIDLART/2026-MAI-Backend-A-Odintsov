package org.server.project.repositories;

import org.server.project.entities.FavoriteBook;
import org.server.project.entities.composite_keys.FavoriteBookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteBookRepository extends JpaRepository<FavoriteBook, FavoriteBookId> {
  List<FavoriteBook> findByUserId(Long userId);
}
