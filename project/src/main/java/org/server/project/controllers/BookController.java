package org.server.project.controllers;

import lombok.RequiredArgsConstructor;
import org.server.project.dto.BookDetailsDto;
import org.server.project.dto.BookDto;
import org.server.project.dto.request.BookRequestDto;
import org.server.project.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;

  @GetMapping("/books")
  public List<BookDto> getAllBooks() {
    return bookService.getAllBooks();
  }

  @GetMapping("/book/{id}")
  public BookDetailsDto getBookInfo(@PathVariable long id) {
    return bookService.getBookInfo(id);
  }

  @PostMapping("/books/create")
  public BookDetailsDto createBook(@RequestBody BookRequestDto book) {
    return bookService.createBook(book);
  }

  @PutMapping("/book/{id}/update")
  public BookDetailsDto updateBook(@PathVariable long id, @RequestBody BookRequestDto book) {
    return bookService.updateBook(id, book);
  }

  @DeleteMapping("/book/{id}/delete")
  public ResponseEntity<Void> deleteBook(@PathVariable long id) {
    bookService.deleteBook(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/books/search")
  public List<BookDetailsDto> searchBooks(@RequestParam String q) {
    return bookService.searchBooks(q);
  }
}
