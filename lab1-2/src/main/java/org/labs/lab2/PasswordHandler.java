package org.labs.lab2;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class PasswordHandler implements HttpHandler {
  private final Random random = new SecureRandom();

  private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
  private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String DIGITS = "0123456789";
  private static final String SPECIAL = "#.,!@&^%*";
  private static final String ALL_CHARS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL;

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"GET".equals(exchange.getRequestMethod())) {
      exchange.sendResponseHeaders(405, -1);
      return;
    }

    try {
      String password = generatePassword();
      Thread.sleep(50);

      byte[] response = password.getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
      exchange.sendResponseHeaders(200, response.length);

      try (OutputStream os = exchange.getResponseBody()) {
        os.write(response);
      }

      System.out.println("Generated: " + password);

    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      exchange.sendResponseHeaders(500, -1);
    }
  }

  private String generatePassword() {
    List<Character> password = new ArrayList<>();
    password.add(getRandomChar(LOWERCASE));
    password.add(getRandomChar(UPPERCASE));
    password.add(getRandomChar(DIGITS));
    password.add(getRandomChar(SPECIAL));

    int length = 8 + random.nextInt(9);
    for (int i = 4; i < length; i++) {
      password.add(getRandomChar(ALL_CHARS));
    }

    Collections.shuffle(password, random);

    StringBuilder result = new StringBuilder();
    for (char c : password) {
      result.append(c);
    }
    return result.toString();
  }

  private char getRandomChar(String chars) {
    int index = random.nextInt(chars.length());
    return chars.charAt(index);
  }
}
