package com.smart_city_service_platform.city_directory_service.controller;

import com.smart_city_service_platform.city_directory_service.model.FAQ;
import com.smart_city_service_platform.city_directory_service.model.FAQCategory;
import com.smart_city_service_platform.city_directory_service.service.FAQService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/faqs")
public class FAQController {

  private final FAQService service;

  @Autowired
  public FAQController(FAQService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<FAQ> create(@RequestBody FAQ faq) {
    return ResponseEntity.ok(service.save(faq));
  }

  @GetMapping
  public ResponseEntity<List<FAQ>> getAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/category/{category}")
  public ResponseEntity<List<FAQ>> getFAQsByCategory(@PathVariable FAQCategory category) {
    return ResponseEntity.ok(service.findByCategory(category));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<FAQ>> getFAQById(@PathVariable Long id) {
    return ResponseEntity.ok(service.findById(id));
  }
}
