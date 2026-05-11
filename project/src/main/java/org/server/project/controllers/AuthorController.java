package org.server.project.controllers;

import lombok.RequiredArgsConstructor;
import org.server.project.dto.AuthorDto;
import org.server.project.dto.request.AuthorRequestDto;
import org.server.project.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {
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

  @PutMapping("/author/{id}/update")
  public AuthorDto updateAuthor(@PathVariable long id, @RequestBody AuthorRequestDto author) {
    return authorService.updateAuthor(id, author);
  }

  @DeleteMapping("/author/{id}/delete")
  public ResponseEntity<Void> deleteAuthor(@PathVariable long id) {
    authorService.deleteAuthor(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/authors/search")
  public List<AuthorDto> searchAuthors(@RequestParam String q) {
    return authorService.searchAuthors(q);
  }
}
