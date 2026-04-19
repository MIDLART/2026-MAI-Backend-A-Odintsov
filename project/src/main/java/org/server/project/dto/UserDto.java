package org.server.project.dto;

import lombok.Data;
import java.util.Set;

@Data
public class UserDto {
  private Long id;
  private String username;
  private Set<Long> favoriteBookIds;
}
