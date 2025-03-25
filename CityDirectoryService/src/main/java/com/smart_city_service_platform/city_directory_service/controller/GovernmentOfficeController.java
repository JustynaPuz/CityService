package com.smart_city_service_platform.city_directory_service.controller;

import com.smart_city_service_platform.city_directory_service.DTO.GovernmentOfficeDTO;
import com.smart_city_service_platform.city_directory_service.model.GovernmentOffice;
import com.smart_city_service_platform.city_directory_service.model.OfficeCategory;
import com.smart_city_service_platform.city_directory_service.service.GovernmentOfficeService;
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
@RequestMapping("/offices")
public class GovernmentOfficeController {

  private final GovernmentOfficeService service;

  public GovernmentOfficeController(GovernmentOfficeService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<GovernmentOffice>> getAllOffices() {
    return ResponseEntity.ok(service.getAllOffices());
  }

  @GetMapping("/{id}")
  public ResponseEntity<GovernmentOffice> getOfficeById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getOfficeById(id));
  }

  @GetMapping("/category/{category}")
  public ResponseEntity<List<GovernmentOffice>> getOfficesByCategory(@PathVariable OfficeCategory category) {
    return ResponseEntity.ok(service.getOfficesByCategory(category));
  }

  @GetMapping("/location/{locationId}")
  public ResponseEntity<List<GovernmentOffice>> getOfficesByLocation(@PathVariable Long locationId) {
    return ResponseEntity.ok(service.getOfficesByLocation(locationId));
  }

  @PostMapping
  public ResponseEntity<GovernmentOffice> createOffice(@RequestBody GovernmentOfficeDTO office) {
    GovernmentOffice savedOffice = service.createOffice(office);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedOffice);
  }

  @PutMapping("/{id}")
  public ResponseEntity<GovernmentOffice> updateOffice(@PathVariable Long id, @RequestBody GovernmentOfficeDTO office) {
    return ResponseEntity.ok(service.updateOffice(id, office));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOffice(@PathVariable Long id) {
    service.deleteOffice(id);
    return ResponseEntity.noContent().build();
  }
}
