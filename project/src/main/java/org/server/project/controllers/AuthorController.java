package org.server.project.controllers;

import org.server.project.dto.AuthorDto;
import org.server.project.dto.request.AuthorRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
  @GetMapping("/authors")
  public List<AuthorDto> getAllAuthors() {
    return List.of(
            new AuthorDto(1L, "Пушкин"),
            new AuthorDto(2L, "Толстой"),
            new AuthorDto(3L, "Достоевский")
    );
  }

  @GetMapping("/author/{id}")
  public AuthorDto getAuthor(@PathVariable long id) {
    return new AuthorDto(id, "автор");
  }

  @PostMapping("/authors")
  public AuthorDto createAuthor(@RequestBody AuthorRequestDto author) {
    return new AuthorDto(1L, author.name());
  }
}
