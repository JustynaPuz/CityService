package com.smartcity.serviceplatform.citydirectoryservice.loadbalancer;

import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstanceController {

  @GetMapping("/instance-id")
  public String getInstanceId() {
    return "I'm running on: " + System.getenv("INSTANCE_NAME");
  }

}
