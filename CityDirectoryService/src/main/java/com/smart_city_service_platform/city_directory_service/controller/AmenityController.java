package com.smart_city_service_platform.city_directory_service.controller;

import com.smart_city_service_platform.city_directory_service.model.Amenity;
import com.smart_city_service_platform.city_directory_service.model.AmenityCategory;
import com.smart_city_service_platform.city_directory_service.service.AmenityService;
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
@RequestMapping("/amenities")
public class AmenityController {

  private final AmenityService service;

  public AmenityController(AmenityService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Amenity>> getAllAmenities() {
    return ResponseEntity.ok(service.getAllAmenities());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Amenity> getAmenityById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getAmenityById(id));
  }

  @GetMapping("/category/{category}")
  public ResponseEntity<List<Amenity>> getAmenitiesByCategory(@PathVariable AmenityCategory category) {
    return ResponseEntity.ok(service.getAmenitiesByCategory(category));
  }

  @GetMapping("/location/{locationId}")
  public ResponseEntity<List<Amenity>> getAmenitiesByLocation(@PathVariable Long locationId) {
    return ResponseEntity.ok(service.getAmenitiesByLocation(locationId));
  }

  @PostMapping
  public ResponseEntity<Amenity> createAmenity(@RequestBody Amenity amenity) {
    Amenity savedAmenity = service.createAmenity(amenity);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedAmenity);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Amenity> updateAmenity(@PathVariable Long id, @RequestBody Amenity amenity) {
    return ResponseEntity.ok(service.updateAmenity(id, amenity));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAmenity(@PathVariable Long id) {
    service.deleteAmenity(id);
    return ResponseEntity.noContent().build();
  }

}
