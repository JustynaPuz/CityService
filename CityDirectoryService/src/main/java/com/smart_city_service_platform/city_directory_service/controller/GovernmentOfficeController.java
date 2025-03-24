//package com.smart_city_service_platform.city_directory_service.controller;
//
//import com.smart_city_service_platform.city_directory_service.model.GovernmentOffice;
//import com.smart_city_service_platform.city_directory_service.service.GovernmentOfficeService;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/offices")
////@RequiredArgsConstructor
//public class GovernmentOfficeController {
//
//  private final GovernmentOfficeService service;
//
//  public GovernmentOfficeController(GovernmentOfficeService service) {
//    this.service = service;
//  }
//
//  @PostMapping
//  public ResponseEntity<GovernmentOffice> create(@RequestBody GovernmentOffice office) {
//    return ResponseEntity.ok(service.save(office));
//  }
//
//  @GetMapping
//  public ResponseEntity<List<GovernmentOffice>> getAll() {
//    return ResponseEntity.ok(service.findAll());
//  }
//}
