package org.server.project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.server.project.entities.composite_keys.AuthorBookId;

@Getter
@Setter
@Entity
@Table(name = "author_books")
public class AuthorBook {
  @EmbeddedId
  private AuthorBookId id;

  @MapsId("authorId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "author_id", nullable = false)
  private Author author;

  @MapsId("bookId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "book_id", nullable = false)
  private Book book;

}