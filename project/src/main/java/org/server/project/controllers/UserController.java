package org.server.project.controllers;

import org.server.project.dto.BookDto;
import org.server.project.dto.UserDto;
import org.server.project.dto.request.UserRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
  @GetMapping("/user/{id}")
  public UserDto getUser(@PathVariable long id) {
    return null;
  }

  @PostMapping("/users")
  public UserDto createUser(@RequestBody UserRequestDto user) {
    return null;
  }

  @GetMapping("/user/{id}/favorite")
  public List<BookDto> getFavoriteBooks(@PathVariable long id) {
    return Collections.emptyList();
  }

  @PostMapping("/user/{id}/favorite")
  public List<BookDto> addFavoriteBooks(@PathVariable long id, @RequestBody Long bookId) {
    return Collections.emptyList();
  }
}
