package org.server.project.dto;

import java.util.Set;

public record BookDto(Long id, String title, Set<AuthorDto> authors) {}
