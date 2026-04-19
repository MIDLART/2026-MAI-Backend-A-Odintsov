package org.server.project.controllers;

import org.server.project.dto.AuthorDto;
import org.server.project.dto.request.AuthorRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class AuthorController {
  @GetMapping("/authors")
  public List<AuthorDto> getAllAuthors() {
    return Collections.emptyList();
  }

  @GetMapping("/author/{id}")
  public AuthorDto getAuthor(@PathVariable long id) {
    return null;
  }

  @PostMapping("/authors")
  public AuthorDto createAuthor(@RequestBody AuthorRequestDto author) {
    return null;
  }
}
