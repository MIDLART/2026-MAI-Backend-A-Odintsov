package org.server.project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book_details")
public class BookDetail {
  @Id
  @Column(name = "book_id", nullable = false)
  private Long id;

  @MapsId
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "book_id")
  private Book book;

  @Column(name = "isbn", length = 13)
  private String isbn;

  @Column(name = "publish_year")
  private Integer publishYear;

  @Column(name = "page_count")
  private Integer pageCount;

  @Column(name = "language", length = Integer.MAX_VALUE)
  private String language;

  @Column(name = "description", length = Integer.MAX_VALUE)
  private String description;
}