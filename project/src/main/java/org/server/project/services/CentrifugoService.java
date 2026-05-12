package org.server.project.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CentrifugoService {

  @Value("${centrifugo.url}")
  private String centrifugoUrl;

  @Value("${centrifugo.api_key}")
  private String apiKey;

  private final RestTemplate restTemplate = new RestTemplate();
  private final ObjectMapper objectMapper = new ObjectMapper();

  public void publish(String channel, Object data) {
    try {
      String json = String.format(
              "{\"method\":\"publish\",\"params\":{\"channel\":\"%s\",\"data\":%s}}",
              channel, objectMapper.writeValueAsString(data)
      );

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-API-Key", apiKey);

      restTemplate.postForEntity(centrifugoUrl, new HttpEntity<>(json, headers), String.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
