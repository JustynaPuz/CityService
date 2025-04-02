package com.smart_city_service_platform.city_directory_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.smart_city_service_platform.city_directory_service"
})
public class CityDirectoryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CityDirectoryServiceApplication.class, args);
	}
}
