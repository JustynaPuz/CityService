package com.smartCityServicePlatform.gateway_service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/call")
public class CallController {

  private final WebClient webClient;

  public CallController(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("http://city-directory-service:8080").build();
  }

  @GetMapping("/instance")
  public Mono<String> callInstanceId() {
    return webClient.get()
        .uri("/instance-id")
        .retrieve()
        .bodyToMono(String.class);
  }
}
