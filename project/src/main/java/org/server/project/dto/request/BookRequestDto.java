package org.server.project.dto.request;

import java.util.Set;

public record BookRequestDto(
        String title,
        Set<Long> authors,
        String isbn,
        Integer publishYear,
        Integer pageCount,
        String language,
        String description)
{}
