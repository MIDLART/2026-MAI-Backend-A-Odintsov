package org.labs.lab1;

public class Main {
  public static void main(String[] args) {
    LRUCache cache = new LRUCache(100);
    cache.set("Jesse", "Pinkman");
    cache.set("Walter", "White");
    cache.set("Jesse", "James");

    System.out.println("res: " + cache.get("Jesse"));

    cache.rem("Walter");
    System.out.println("res: " + cache.get("Walter"));
  }
}
