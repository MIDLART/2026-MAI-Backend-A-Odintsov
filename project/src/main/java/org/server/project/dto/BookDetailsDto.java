package org.server.project.dto;

import lombok.Data;

import java.util.Set;

@Data
public class BookDetailsDto {
  private Long id;
  private String title;
  private Set<AuthorDto> authors;
  private String isbn;
  private Integer publishYear;
  private Integer pageCount;
  private String language;
  private String description;
}
