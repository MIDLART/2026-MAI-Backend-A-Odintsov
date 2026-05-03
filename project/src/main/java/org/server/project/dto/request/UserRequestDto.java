package org.server.project.dto.request;

import java.util.Set;

public record UserRequestDto(String username, Set<Long> favoriteBookIds) {}
