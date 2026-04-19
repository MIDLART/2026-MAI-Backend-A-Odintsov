package org.labs.lab2;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

// http://localhost:8080/generate
// http://localhost/gunicorn/generate
public class PasswordGeneratorApp {
  public static void main(String[] args) throws IOException {
    int port = 8080;
    if (args.length > 0) {
      port = Integer.parseInt(args[0]);
    }

    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

    server.createContext("/generate", new PasswordHandler());
    server.createContext("/health", new HealthHandler());

    server.setExecutor(Executors.newFixedThreadPool(4));

    server.start();

    System.out.println("Password Generator App started!");
    System.out.println("Listening on: http://localhost:" + port);
    System.out.println("Endpoints:");
    System.out.println("  GET /generate - generate password");
    System.out.println("  GET /health   - health check");
  }
}
