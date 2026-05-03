package org.server.project.controllers;

import lombok.RequiredArgsConstructor;
import org.server.project.dto.AuthorDto;
import org.server.project.dto.request.AuthorRequestDto;
import org.server.project.services.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {
//  @GetMapping("/authors")
//  public List<AuthorDto> getAllAuthors() {
//    return List.of(
//            new AuthorDto(1L, "Пушкин"),
//            new AuthorDto(2L, "Толстой"),
//            new AuthorDto(3L, "Достоевский")
//    );
//  }
//
//  @GetMapping("/author/{id}")
//  public AuthorDto getAuthor(@PathVariable long id) {
//    return new AuthorDto(id, "автор");
//  }
//
//  @PostMapping("/authors/create")
//  public AuthorDto createAuthor(@RequestBody AuthorRequestDto author) {
//    return new AuthorDto(1L, author.name());
//  }

  private final AuthorService authorService;

  @GetMapping("/authors")
  public List<AuthorDto> getAllAuthors() {
    return authorService.getAllAuthors();
  }

  @GetMapping("/author/{id}")
  public AuthorDto getAuthor(@PathVariable long id) {
    return authorService.getAuthor(id);
  }

  @PostMapping("/authors/create")
  public AuthorDto createAuthor(@RequestBody AuthorRequestDto author) {
    return authorService.createAuthor(author);
  }

  @GetMapping("/authors/search")
  public List<AuthorDto> searchAuthors(@RequestParam String q) {
    return authorService.searchAuthors(q);
  }
}
