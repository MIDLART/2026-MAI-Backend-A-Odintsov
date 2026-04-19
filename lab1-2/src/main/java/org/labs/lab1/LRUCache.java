package org.labs.lab1;

import java.util.LinkedHashMap;
import java.util.SequencedMap;

public class LRUCache {
  private final int capacity;
  private final SequencedMap<String, String> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new LinkedHashMap<>(capacity, 0.75f, true);
  }

  public String get(String key) {
    return map.getOrDefault(key, "");
  }

  public void set(String key, String value) {
    map.putLast(key, value);
    if (map.size() > capacity) {
      map.pollFirstEntry();
    }
  }

  public void rem(String key) {
    map.remove(key);
  }
}
