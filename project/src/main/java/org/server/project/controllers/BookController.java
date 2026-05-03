package org.server.project.controllers;

import lombok.RequiredArgsConstructor;
import org.server.project.dto.AuthorDto;
import org.server.project.dto.BookDetailsDto;
import org.server.project.dto.BookDto;
import org.server.project.dto.request.BookRequestDto;
import org.server.project.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class BookController {
//  @GetMapping("/books")
//  public List<BookDto> getAllBooks() {
//    return List.of(
//            new BookDto(1L, "книга", Set.of(
//                    new AuthorDto(1L, "автор 1"),
//                    new AuthorDto(2L, "автор 2"))
//            ),
//            new BookDto(2L, "книга 2", Set.of(
//                    new AuthorDto(1L, "автор 3"))
//            )
//    );
//  }
//
//  @GetMapping("/book/{id}")
//  public BookDetailsDto getBookInfo(@PathVariable long id) {
//    return new BookDetailsDto(
//            id,
//            "книга",
//            Set.of(new AuthorDto(1L, "автор")),
//            "111-111",
//            1920,
//            100,
//            "ru",
//            "описание"
//    );
//  }
//
//  @PostMapping("/books/create")
//  public BookDetailsDto createBook(@RequestBody BookRequestDto book) {
//    return new BookDetailsDto(1L,
//            book.title(),
//            Set.of(new AuthorDto(1L, "автор 1"), new AuthorDto(2L, "автор 2")),
//            book.isbn(),
//            book.publishYear(),
//            book.pageCount(),
//            book.language(),
//            book.description()
//    );
//  }

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

  @GetMapping("/books/search")
  public List<BookDetailsDto> searchBooks(@RequestParam String q) {
    return bookService.searchBooks(q);
  }
}
