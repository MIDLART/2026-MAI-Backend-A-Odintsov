package org.server.project.controllers;

import lombok.RequiredArgsConstructor;
import org.server.project.dto.BookDto;
import org.server.project.dto.UserDto;
import org.server.project.dto.request.UserRequestDto;
import org.server.project.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/users")
  public List<UserDto> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/user/{id}")
  public UserDto getUser(@PathVariable long id) {
    return userService.getUser(id);
  }

  @PostMapping("/users/create")
  public UserDto createUser(@RequestBody UserRequestDto user) {
    return userService.createUser(user);
  }

  @PutMapping("/user/{id}/update")
  public UserDto updateUser(@PathVariable long id, @RequestBody UserRequestDto user) {
    return userService.updateUser(id, user);
  }

  @DeleteMapping("/user/{id}/delete")
  public ResponseEntity<Void> deleteUser(@PathVariable long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
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

  @DeleteMapping("/user/{id}/favorite/remove")
  public List<BookDto> removeFavoriteBook(@PathVariable long id, @RequestBody Long bookId) {
    return userService.removeFavoriteBook(id, bookId);
  }
}
