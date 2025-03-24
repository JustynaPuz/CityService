//package com.smart_city_service_platform.city_directory_service.service;
//
//import com.smart_city_service_platform.city_directory_service.model.Amenity;
//import com.smart_city_service_platform.city_directory_service.repository.AmenityRepository;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
////@RequiredArgsConstructor
//public class AmenityService {
//
//  private final AmenityRepository repository;
//
//  public AmenityService(AmenityRepository repository) {
//    this.repository = repository;
//  }
//
//  public Amenity save(Amenity amenity) {
//    return repository.save(amenity);
//  }
//
//  public List<Amenity> findAll() {
//    return repository.findAll();
//  }
//
//  public List<Amenity> findByCategory(String category) {
//    return repository.findByCategory(category);
//  }
//
//  public List<Amenity> findByLocation(String location) {
//    return repository.findByLocation(location);
//  }
//}
