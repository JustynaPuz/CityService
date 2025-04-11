package com.smart_city_service_platform.city_directory_service.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.time.Instant;
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

  private static final URI VALIDATION_TYPE = URI.create("https://smartcity.api/errors/validation");
  private static final URI NOT_FOUND_TYPE = URI.create("https://smartcity.api/errors/not-found");
  private static final URI DATABASE_TYPE = URI.create("https://smartcity.api/errors/database");
  private static final URI MALFORMED_TYPE = URI.create("https://smartcity.api/errors/malformed");
  private static final URI INTERNAL_TYPE = URI.create("https://smartcity.api/errors/internal");
  private static final URI UNEXPECTED_TYPE = URI.create("https://smartcity.api/errors/unexpected");

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleValidationError(MethodArgumentNotValidException ex,
      HttpServletRequest request) {
    ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problem.setType(VALIDATION_TYPE);
    problem.setTitle("Validation failed");
    problem.setDetail("Request contains invalid or missing fields.");
    problem.setProperty("timestamp", Instant.now());
    problem.setProperty("path", request.getRequestURI());

    Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
        .collect(Collectors.toMap(
            FieldError::getField,
            FieldError::getDefaultMessage,
            (msg1, msg2) -> msg1 + "; " + msg2
        ));

    problem.setProperty("errors", errors);
    return problem;
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ProblemDetail handleConstraintViolation(ConstraintViolationException ex,
      HttpServletRequest request) {
    ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problem.setType(VALIDATION_TYPE);
    problem.setTitle("Validation failed for request parameters");
    problem.setDetail("One or more parameters are invalid.");
    problem.setProperty("timestamp", Instant.now());
    problem.setProperty("path", request.getRequestURI());

    Map<String, String> errors = ex.getConstraintViolations().stream()
        .collect(Collectors.toMap(
            v -> v.getPropertyPath().toString(),
            ConstraintViolation::getMessage,
            (msg1, msg2) -> msg1 + "; " + msg2
        ));

    problem.setProperty("errors", errors);
    return problem;
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ProblemDetail handleEntityNotFound(EntityNotFoundException ex,
      HttpServletRequest request) {
    ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
    problem.setType(NOT_FOUND_TYPE);
    problem.setTitle("Resource not found");
    problem.setDetail(ex.getMessage());
    problem.setProperty("timestamp", Instant.now());
    problem.setProperty("path", request.getRequestURI());
    return problem;
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ProblemDetail handleDataIntegrityViolation(DataIntegrityViolationException ex,
      HttpServletRequest request) {
    ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
    problem.setType(DATABASE_TYPE);
    problem.setTitle("Database constraint violation");
    problem.setDetail("The request could not be completed due to a database constraint violation.");
    problem.setProperty("timestamp", Instant.now());
    problem.setProperty("path", request.getRequestURI());
    return problem;
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ProblemDetail handleJsonParseError(HttpMessageNotReadableException ex,
      HttpServletRequest request) {
    ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problem.setType(MALFORMED_TYPE);
    problem.setTitle("Malformed JSON or invalid input");
    problem.setDetail("The request body is malformed or contains invalid values.");
    problem.setProperty("timestamp", Instant.now());
    problem.setProperty("path", request.getRequestURI());
    return problem;
  }

  @ExceptionHandler(InvocationTargetException.class)
  public ProblemDetail handleInvocationTarget(InvocationTargetException ex,
      HttpServletRequest request) {
    Throwable cause = ex.getTargetException();
    if (cause instanceof DataIntegrityViolationException dive) {
      return handleDataIntegrityViolation(dive, request);
    }

    ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    problem.setType(INTERNAL_TYPE);
    problem.setTitle("Internal server error");
    problem.setDetail("An internal error occurred.");
    problem.setProperty("timestamp", Instant.now());
    problem.setProperty("path", request.getRequestURI());
    return problem;
  }

  @ExceptionHandler(Exception.class)
  public ProblemDetail handleGenericError(Exception ex, HttpServletRequest request) {
    ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    problem.setType(UNEXPECTED_TYPE);
    problem.setTitle("Unexpected server error");
    problem.setDetail("An unexpected error occurred.");
    problem.setProperty("timestamp", Instant.now());
    problem.setProperty("path", request.getRequestURI());
    return problem;
  }

}
