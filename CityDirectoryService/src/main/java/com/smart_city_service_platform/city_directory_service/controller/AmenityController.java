package com.smart_city_service_platform.city_directory_service.controller;

import com.smart_city_service_platform.city_directory_service.DTO.AmenityRequestDTO;
import com.smart_city_service_platform.city_directory_service.DTO.AmenityResponse;
import com.smart_city_service_platform.city_directory_service.model.AmenityCategory;
import com.smart_city_service_platform.city_directory_service.service.AmenityService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/amenities")
public class AmenityController {

  private final AmenityService service;

  public AmenityController(AmenityService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<AmenityResponse>> getAllAmenities() {
    return ResponseEntity.ok(service.getAllAmenities());
  }

  @GetMapping("/{id}")
  public ResponseEntity<AmenityResponse> getAmenityById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getAmenityById(id));
  }

  @GetMapping("/category/{category}")
  public ResponseEntity<List<AmenityResponse>> getAmenitiesByCategory(
      @PathVariable AmenityCategory category) {
    return ResponseEntity.ok(service.getAmenitiesByCategory(category));
  }

  @GetMapping("/location/{locationId}")
  public ResponseEntity<List<AmenityResponse>> getAmenitiesByLocation(
      @PathVariable Long locationId) {
    return ResponseEntity.ok(service.getAmenitiesByLocation(locationId));
  }

  @PostMapping
  public ResponseEntity<AmenityResponse> createAmenity(
      @Valid @RequestBody AmenityRequestDTO amenity) {
    AmenityResponse savedAmenity = service.createAmenity(amenity);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedAmenity);
  }

  @PutMapping("/{id}")
  public ResponseEntity<AmenityResponse> updateAmenity(@PathVariable Long id,
      @Valid @RequestBody AmenityRequestDTO amenity) {
    return ResponseEntity.ok(service.updateAmenity(id, amenity));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAmenity(@PathVariable Long id) {
    service.deleteAmenity(id);
    return ResponseEntity.noContent().build();
  }

}
