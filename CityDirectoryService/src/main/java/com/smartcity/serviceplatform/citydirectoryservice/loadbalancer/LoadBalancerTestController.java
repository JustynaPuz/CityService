package com.smartcity.serviceplatform.citydirectoryservice.loadbalancer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadBalancerTestController {

  private final RestTemplate restTemplate;

  public LoadBalancerTestController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping("/test-loadbalancer")
  public String test() {
    String response = restTemplate.getForObject("http://CITY-DIRECTORY-SERVICE/instance-id", String.class);
    return "Response from: " + response;
  }
}
