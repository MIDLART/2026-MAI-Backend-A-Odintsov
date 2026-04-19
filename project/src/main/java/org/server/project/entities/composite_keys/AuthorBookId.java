package org.server.project.entities.composite_keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class AuthorBookId implements java.io.Serializable {
  @Serial
  private static final long serialVersionUID = 7474229133087371702L;
  @Column(name = "author_id", nullable = false)
  private Long authorId;

  @Column(name = "book_id", nullable = false)
  private Long bookId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    AuthorBookId entity = (AuthorBookId) o;
    return Objects.equals(this.authorId, entity.authorId) &&
            Objects.equals(this.bookId, entity.bookId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authorId, bookId);
  }

}