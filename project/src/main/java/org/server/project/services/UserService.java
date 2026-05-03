package org.server.project.services;

import lombok.RequiredArgsConstructor;
import org.server.project.dto.BookDto;
import org.server.project.dto.UserDto;
import org.server.project.dto.request.UserRequestDto;
import org.server.project.entities.Book;
import org.server.project.entities.FavoriteBook;
import org.server.project.entities.User;
import org.server.project.entities.composite_keys.FavoriteBookId;
import org.server.project.repositories.BookRepository;
import org.server.project.repositories.FavoriteBookRepository;
import org.server.project.repositories.UserRepository;
import org.server.project.utils.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final FavoriteBookRepository favoriteBookRepository;
  private final BookRepository bookRepository;

  private final BCryptPasswordEncoder passwordEncoder;

  public UserDto getUser(long id) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Пользователь с id " + id + " не найден"));
    return toDto(user);
  }

  public UserDto createUser(UserRequestDto dto) {
    User user = new User();
    user.setUsername(dto.username());
    user.setPassword(passwordEncoder.encode(dto.password()));
    User saved = userRepository.save(user);
    return toDto(saved);
  }

  public List<UserDto> searchUsers(String q) {
    return userRepository.findByUsernameContainingIgnoreCase(q)
            .stream()
            .map(this::toDto)
            .toList();
  }

  public List<BookDto> getFavoriteBooks(long userId) {
    userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("Пользователь с id " + userId + " не найден"));

    return favoriteBookRepository.findByUserId(userId)
            .stream()
            .map(FavoriteBook::getBook)
            .map(BookService::toBookDto)
            .toList();
  }

  public List<BookDto> addFavoriteBook(long userId, Long bookId) {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("Пользователь с id " + userId + " не найден"));

    Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new ResourceNotFoundException("Книга с id " + bookId + " не найдена"));

    FavoriteBookId favoriteId = new FavoriteBookId();
    favoriteId.setUserId(userId);
    favoriteId.setBookId(bookId);

    if (!favoriteBookRepository.existsById(favoriteId)) {
      FavoriteBook favorite = new FavoriteBook();
      favorite.setId(favoriteId);
      favorite.setUser(user);
      favorite.setBook(book);
      favoriteBookRepository.save(favorite);
    }

    return getFavoriteBooks(userId);
  }

  private UserDto toDto(User user) {
    return new UserDto(user.getId(), user.getUsername(), null);
  }
}