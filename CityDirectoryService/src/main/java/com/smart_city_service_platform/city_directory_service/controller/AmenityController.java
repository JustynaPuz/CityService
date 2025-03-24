//package com.smart_city_service_platform.city_directory_service.controller;
//
//import com.smart_city_service_platform.city_directory_service.model.Amenity;
//import com.smart_city_service_platform.city_directory_service.service.AmenityService;
//import java.util.List;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/amenities")
////@RequiredArgsConstructor
//public class AmenityController {
//
//  private final AmenityService service;
//
//  public AmenityController(AmenityService service) {
//    this.service = service;
//  }
//
//  @PostMapping
//  public ResponseEntity<Amenity> create(@RequestBody Amenity amenity) {
//    return ResponseEntity.ok(service.save(amenity));
//  }
//
//  @GetMapping
//  public ResponseEntity<List<Amenity>> getAll() {
//    return ResponseEntity.ok(service.findAll());
//  }
//}
