package org.server.project.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class UserRequestDto {
  private String username;
  private Set<Long> favoriteBookIds;
}
