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
public class FavoriteBookId implements java.io.Serializable {
  @Serial
  private static final long serialVersionUID = 7357672254206601026L;
  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "book_id", nullable = false)
  private Long bookId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    FavoriteBookId entity = (FavoriteBookId) o;
    return Objects.equals(this.userId, entity.userId) &&
            Objects.equals(this.bookId, entity.bookId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, bookId);
  }

}