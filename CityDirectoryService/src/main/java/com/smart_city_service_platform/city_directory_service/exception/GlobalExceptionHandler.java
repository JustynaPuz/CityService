package com.smart_city_service_platform.city_directory_service.exception;

import jakarta.persistence.EntityNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleValidationError(MethodArgumentNotValidException ex) {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setType(URI.create("https://smartcity.api/errors/validation"));
    problemDetail.setTitle("Validation failed");
    problemDetail.setDetail("Request contains invalid or missing fields.");

    Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
        .collect(Collectors.toMap(
            FieldError::getField,
            FieldError::getDefaultMessage,
            (msg1, msg2) -> msg1 + "; " + msg2
        ));

    problemDetail.setProperty("errors", errors);
    return problemDetail;
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ProblemDetail handleEntityNotFound(EntityNotFoundException ex) {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
    problemDetail.setType(URI.create("https://smartcity.api/errors/not-found"));
    problemDetail.setTitle("Resource not found");
    problemDetail.setDetail(ex.getMessage());
    return problemDetail;
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ProblemDetail handleDataIntegrityViolation(DataIntegrityViolationException ex) {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setType(URI.create("https://smartcity.api/errors/database"));
    problemDetail.setTitle("Database constraint violation");
    problemDetail.setDetail(ex.getMostSpecificCause().getMessage());
    return problemDetail;
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ProblemDetail handleJsonParseError(HttpMessageNotReadableException ex) {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setType(URI.create("https://smartcity.api/errors/malformed"));
    problemDetail.setTitle("Malformed JSON or invalid field value");
    problemDetail.setDetail("The request could not be parsed or contains invalid fields.");
    return problemDetail;
  }

  @ExceptionHandler(InvocationTargetException.class)
  public ProblemDetail handleInvocationTarget(InvocationTargetException ex) {
    Throwable cause = ex.getTargetException();
    if (cause instanceof DataIntegrityViolationException dive) {
      return handleDataIntegrityViolation(dive);
    }

    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    problemDetail.setType(URI.create("https://smartcity.api/errors/internal"));
    problemDetail.setTitle("Internal error");
    problemDetail.setDetail(cause.getMessage());
    return problemDetail;
  }

  @ExceptionHandler(Exception.class)
  public ProblemDetail handleGenericError(Exception ex) {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    problemDetail.setType(URI.create("https://smartcity.api/errors/unexpected"));
    problemDetail.setTitle("Unexpected server error");
    problemDetail.setDetail(ex.getMessage());
    return problemDetail;
  }
}
