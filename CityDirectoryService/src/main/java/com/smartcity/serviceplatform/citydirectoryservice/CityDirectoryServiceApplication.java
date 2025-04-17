package com.smartcity.serviceplatform.citydirectoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.smart_city_service_platform.city_directory_service.service",
		"com.smart_city_service_platform.city_directory_service.controller"
})
public class CityDirectoryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CityDirectoryServiceApplication.class, args);
	}
}
