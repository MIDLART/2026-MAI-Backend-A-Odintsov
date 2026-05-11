package org.server.project.services;

import lombok.RequiredArgsConstructor;
import org.server.project.dto.AuthorDto;
import org.server.project.dto.BookDetailsDto;
import org.server.project.dto.BookDto;
import org.server.project.dto.request.BookRequestDto;
import org.server.project.entities.Author;
import org.server.project.entities.Book;
import org.server.project.entities.BookDetail;
import org.server.project.repositories.AuthorRepository;
import org.server.project.repositories.BookRepository;
import org.server.project.utils.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;

  public List<BookDto> getAllBooks() {
    return bookRepository.findAll()
            .stream()
            .map(BookService::toBookDto)
            .toList();
  }

  public BookDetailsDto getBookInfo(long id) {
    Book book = bookRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Книга с id " + id + " не найдена"));
    return toBookDetailsDto(book);
  }

  public BookDetailsDto createBook(BookRequestDto dto) {
    Set<Author> authors = dto.authors().stream()
            .map(id -> authorRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Автор с id " + id + " не найден")))
            .collect(Collectors.toSet());

    Book book = new Book();
    book.setTitle(dto.title());

    BookDetail bookDetail = new BookDetail();
    bookDetail.setIsbn(dto.isbn());
    bookDetail.setPublishYear(dto.publishYear());
    bookDetail.setPageCount(dto.pageCount());
    bookDetail.setLanguage(dto.language());
    bookDetail.setDescription(dto.description());
    bookDetail.setBook(book);

    book.setBookDetail(bookDetail);

    for (Author author : authors) {
      author.getBooks().add(book);
    }
    book.setAuthors(authors);

    Book saved = bookRepository.save(book);
    return toBookDetailsDto(saved);
  }

  public BookDetailsDto updateBook(long id, BookRequestDto dto) {
    Book book = bookRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Книга с id " + id + " не найдена"));

    book.setTitle(dto.title());

    Set<Author> authors = dto.authors().stream()
            .map(authorId -> authorRepository.findById(authorId)
                    .orElseThrow(() -> new ResourceNotFoundException("Автор с id " + authorId + " не найден")))
            .collect(Collectors.toSet());
    book.setAuthors(authors);
    for (Author author : authors) {
      author.getBooks().add(book);
    }

    BookDetail detail = book.getBookDetail();
    if (detail != null) {
      detail.setIsbn(dto.isbn());
      detail.setPublishYear(dto.publishYear());
      detail.setPageCount(dto.pageCount());
      detail.setLanguage(dto.language());
      detail.setDescription(dto.description());
    }

    Book saved = bookRepository.save(book);
    return toBookDetailsDto(saved);
  }

  public void deleteBook(long id) {
    if (!bookRepository.existsById(id)) {
      throw new ResourceNotFoundException("Книга с id " + id + " не найдена");
    }
    bookRepository.deleteById(id);
  }

  public List<BookDetailsDto> searchBooks(String q) {
    return bookRepository.searchByTitleOrDescription(q)
            .stream()
            .map(this::toBookDetailsDto)
            .toList();
  }

  // --- Маппинг ---

  public static BookDto toBookDto(Book book) {
    Set<AuthorDto> authors = book.getAuthors().stream()
            .map(a -> new AuthorDto(a.getId(), a.getName()))
            .collect(Collectors.toSet());
    return new BookDto(book.getId(), book.getTitle(), authors);
  }

  private BookDetailsDto toBookDetailsDto(Book book) {
    return new BookDetailsDto(
            book.getId(),
            book.getTitle(),
            book.getAuthors().stream()
                    .map(a -> new AuthorDto(a.getId(), a.getName()))
                    .collect(Collectors.toSet()),
            book.getBookDetail().getIsbn(),
            book.getBookDetail().getPublishYear(),
            book.getBookDetail().getPageCount(),
            book.getBookDetail().getLanguage(),
            book.getBookDetail().getDescription()
    );
  }
}
