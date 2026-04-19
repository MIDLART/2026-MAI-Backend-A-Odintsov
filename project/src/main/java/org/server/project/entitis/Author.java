package org.server.project.entitis;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
  private String name;

  @ManyToMany
  @JoinTable(name = "author_books",
          joinColumns = @JoinColumn(name = "author_id"),
          inverseJoinColumns = @JoinColumn(name = "book_id"))
  private Set<Book> books = new LinkedHashSet<>();

}