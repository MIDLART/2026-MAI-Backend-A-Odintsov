package org.server.project.dto;

import java.util.Set;

public record UserDto(Long id, String username, Set<Long> favoriteBookIds) {}
