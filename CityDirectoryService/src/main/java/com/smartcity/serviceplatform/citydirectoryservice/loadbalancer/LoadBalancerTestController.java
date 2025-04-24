package com.smartcity.serviceplatform.citydirectoryservice.loadbalancer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadBalancerTestController {

  private final RestTemplate restTemplate;
  private static final Logger log = LoggerFactory.getLogger(LoadBalancerTestController.class);


  public LoadBalancerTestController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping("/test-loadbalancer")
  public String test() {
    log.info("Calling CITY-DIRECTORY-SERVICE at /instance-id");

    String response = restTemplate.getForObject("http://CITY-DIRECTORY-SERVICE/instance-id", String.class);

    log.info("Received response from instance: {}", response);

    return "Response from: " + response;
  }
}
