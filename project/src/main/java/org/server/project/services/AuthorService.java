package org.server.project.services;

import lombok.RequiredArgsConstructor;
import org.server.project.dto.AuthorDto;
import org.server.project.dto.request.AuthorRequestDto;
import org.server.project.entities.Author;
import org.server.project.repositories.AuthorRepository;
import org.server.project.utils.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
  private final AuthorRepository authorRepository;

  public List<AuthorDto> getAllAuthors() {
    return authorRepository.findAll()
            .stream()
            .map(this::toDto)
            .toList();
  }

  public AuthorDto getAuthor(long id) {
    Author author = authorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Автор с id " + id + " не найден"));
    return toDto(author);
  }

  public AuthorDto createAuthor(AuthorRequestDto dto) {
    Author author = new Author();
    author.setName(dto.name());
    Author saved = authorRepository.save(author);
    return toDto(saved);
  }

  public AuthorDto updateAuthor(long id, AuthorRequestDto dto) {
    Author author = authorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Автор с id " + id + " не найден"));
    author.setName(dto.name());
    Author saved = authorRepository.save(author);
    return toDto(saved);
  }

  public void deleteAuthor(long id) {
    if (!authorRepository.existsById(id)) {
      throw new ResourceNotFoundException("Автор с id " + id + " не найден");
    }
    authorRepository.deleteById(id);
  }

  public List<AuthorDto> searchAuthors(String q) {
    return authorRepository.findByNameContainingIgnoreCase(q)
            .stream()
            .map(this::toDto)
            .toList();
  }

  private AuthorDto toDto(Author author) {
    return new AuthorDto(author.getId(), author.getName());
  }
}
