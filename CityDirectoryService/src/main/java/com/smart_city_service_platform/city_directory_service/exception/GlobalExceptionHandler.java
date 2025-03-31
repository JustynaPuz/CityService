package com.smart_city_service_platform.city_directory_service.exception;

import jakarta.persistence.EntityNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // 404 - Not Found
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleEntityNotFound(EntityNotFoundException ex) {
    Map<String, String> error = new HashMap<>();
    error.put("error", ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  // 400 - Bad Request
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationError(
      MethodArgumentNotValidException ex) {
    Map<String, String> error = new HashMap<>();
    error.put("error", "Invalid input: " + Objects.requireNonNull(
        ex.getBindingResult().getFieldError()).getDefaultMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  // 500 - Internal Server Error
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, String>> handleGenericError(Exception ex) {
    Map<String, String> error = new HashMap<>();
    error.put("error", "Internal server error: " + ex.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<Map<String, String>> handleJsonParseError(HttpMessageNotReadableException ex) {
    Map<String, String> error = new HashMap<>();
    error.put("error", "Invalid request: malformed JSON or missing required field");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }


  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Map<String, String>> handleDataIntegrityViolation(
      DataIntegrityViolationException ex) {
    Map<String, String> error = new HashMap<>();
    error.put("error", "Invalid input: " + ex.getMostSpecificCause().getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(InvocationTargetException.class)
  public ResponseEntity<Map<String, String>> handleInvocationTarget(InvocationTargetException ex) {
    Throwable cause = ex.getTargetException(); // unwrap
    Map<String, String> error = new HashMap<>();

    // Optional: smart fallback
    if (cause instanceof DataIntegrityViolationException dive) {
      error.put("error", "Invalid input: " + dive.getMostSpecificCause().getMessage());
      return ResponseEntity.badRequest().body(error);
    }

    error.put("error", "Internal error: " + cause.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}
