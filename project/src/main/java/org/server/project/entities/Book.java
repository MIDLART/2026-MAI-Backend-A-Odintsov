package org.server.project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
  private String title;

  @ManyToMany(mappedBy = "books")
  private Set<Author> authors = new LinkedHashSet<>();

  @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
  private BookDetail bookDetail;

  @ManyToMany
  @JoinTable(name = "favorite_books",
          joinColumns = @JoinColumn(name = "book_id"),
          inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> users = new LinkedHashSet<>();
}