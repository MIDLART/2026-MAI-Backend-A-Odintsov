package org.server.project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "username", nullable = false, length = Integer.MAX_VALUE)
  private String username;

  @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
  private String password;

  @ManyToMany(mappedBy = "users")
  private Set<Book> books = new LinkedHashSet<>();

}