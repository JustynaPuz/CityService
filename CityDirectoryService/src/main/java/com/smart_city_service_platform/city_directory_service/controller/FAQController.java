package com.smart_city_service_platform.city_directory_service.controller;

import com.smart_city_service_platform.city_directory_service.DTO.FaqRequestDTO;
import com.smart_city_service_platform.city_directory_service.model.FAQ;
import com.smart_city_service_platform.city_directory_service.model.FAQCategory;
import com.smart_city_service_platform.city_directory_service.service.FAQService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faqs")
public class FAQController {

  private final FAQService service;

  public FAQController(FAQService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<FAQ>> getAllFAQ() {
    return ResponseEntity.ok(service.getAllFAQ());
  }

  @GetMapping("/{id}")
  public ResponseEntity<FAQ> getFAQById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getFAQById(id));
  }

  @GetMapping("/category/{category}")
  public ResponseEntity<List<FAQ>> getFAQByCategory(@PathVariable FAQCategory category) {
    return ResponseEntity.ok(service.getFAQByCategory(category));
  }

  @PostMapping
  public ResponseEntity<FAQ> createFAQ(@RequestBody FaqRequestDTO faq) {
    FAQ savedFAQ = service.createFAQ(faq);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedFAQ);
  }

  @PutMapping("/{id}")
  public ResponseEntity<FAQ> updateFAQ(@PathVariable Long id, @RequestBody FaqRequestDTO faq) {
    return ResponseEntity.ok(service.updateFAQ(id, faq));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFAQ(@PathVariable Long id) {
    service.deleteFAQ(id);
    return ResponseEntity.noContent().build();
  }


}
