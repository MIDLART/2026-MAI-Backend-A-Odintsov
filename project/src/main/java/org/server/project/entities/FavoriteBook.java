package org.server.project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.server.project.entities.composite_keys.FavoriteBookId;

@Getter
@Setter
@Entity
@Table(name = "favorite_books")
public class FavoriteBook {
  @EmbeddedId
  private FavoriteBookId id;

  @MapsId("userId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @MapsId("bookId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "book_id", nullable = false)
  private Book book;

}