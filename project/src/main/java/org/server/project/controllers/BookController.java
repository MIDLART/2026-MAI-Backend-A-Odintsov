package org.server.project.controllers;

import org.server.project.dto.BookDetailsDto;
import org.server.project.dto.BookDto;
import org.server.project.dto.request.BookRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
  @GetMapping("/books")
  public List<BookDto> getAllBooks() {
    return Collections.emptyList();
  }

  @GetMapping("/book/{id}")
  public BookDetailsDto getBookInfo(@PathVariable int id) {
    return null;
  }

  @PostMapping("/books")
  public BookDetailsDto createBook(@RequestBody BookRequestDto book) {
    return null;
  }
}
