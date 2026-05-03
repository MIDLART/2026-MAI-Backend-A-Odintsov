package org.server.project.dto;

import java.util.Set;

public record BookDetailsDto(
        Long id,
        String title,
        Set<AuthorDto> authors,
        String isbn,
        Integer publishYear,
        Integer pageCount,
        String language,
        String description)
{}
