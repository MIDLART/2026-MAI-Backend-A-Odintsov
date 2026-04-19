package org.server.project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {
  @GetMapping("/profile")
  public ResponseEntity<Map<String, Object>> getProfile() {
    Map<String, Object> response = new HashMap<>();
    response.put("id", 1);
    response.put("username", "john_doe");
    response.put("email", "john@example.com");
    response.put("first_name", "John");
    response.put("last_name", "Doe");
    return ResponseEntity.ok(response);
  }
}
