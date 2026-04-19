package org.server.project.dto.request;

import lombok.Data;
import org.server.project.dto.AuthorDto;

import java.util.Set;

@Data
public class BookRequestDto {
  private String title;
  private Set<AuthorDto> authors;
  private String isbn;
  private Integer publishYear;
  private Integer pageCount;
  private String language;
  private String description;
}
