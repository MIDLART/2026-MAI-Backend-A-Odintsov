package org.server.project.dto.request;

import org.server.project.dto.AuthorDto;

import java.util.Set;

public record BookRequestDto(
        String title,
        Set<AuthorDto> authors,
        String isbn,
        Integer publishYear,
        Integer pageCount,
        String language,
        String description)
{}
