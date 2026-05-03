package org.server.project.controllers;

import lombok.RequiredArgsConstructor;
import org.server.project.dto.AuthorDto;
import org.server.project.dto.BookDto;
import org.server.project.dto.UserDto;
import org.server.project.dto.request.UserRequestDto;
import org.server.project.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserController {
//  @GetMapping("/user/{id}")
//  public UserDto getUser(@PathVariable long id) {
//    return new UserDto(
//            id,
//            "пользователь",
//            null
//    );
//  }
//
//  @PostMapping("/users/create")
//  public UserDto createUser(@RequestBody UserRequestDto user) {
//    return new UserDto(
//            1L,
//            user.username(),
//            null
//    );
//  }
//
//  @GetMapping("/user/{id}/favorite")
//  public List<BookDto> getFavoriteBooks(@PathVariable long id) {
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
//  @PostMapping("/user/{id}/favorite/add")
//  public List<BookDto> addFavoriteBooks(@PathVariable long id, @RequestBody Long bookId) {
//    return List.of(
//            new BookDto(1L, "книга", Set.of(
//                    new AuthorDto(1L, "автор 1"),
//                    new AuthorDto(2L, "автор 2"))
//            ),
//            new BookDto(bookId, "книга 2", Set.of(
//                    new AuthorDto(1L, "автор 3"))
//            )
//    );
//  }

  private final UserService userService;

  @GetMapping("/user/{id}")
  public UserDto getUser(@PathVariable long id) {
    return userService.getUser(id);
  }

  @PostMapping("/users/create")
  public UserDto createUser(@RequestBody UserRequestDto user) {
    return userService.createUser(user);
  }

  @GetMapping("/users/search")
  public List<UserDto> searchUsers(@RequestParam String q) {
    return userService.searchUsers(q);
  }

  @GetMapping("/user/{id}/favorite")
  public List<BookDto> getFavoriteBooks(@PathVariable long id) {
    return userService.getFavoriteBooks(id);
  }

  @PostMapping("/user/{id}/favorite/add")
  public List<BookDto> addFavoriteBooks(@PathVariable long id, @RequestBody Long bookId) {
    return userService.addFavoriteBook(id, bookId);
  }
}
