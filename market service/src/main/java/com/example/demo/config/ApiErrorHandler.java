package com.example.demo.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiErrorHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handle(MethodArgumentNotValidException ex){
    var details = ex.getBindingResult().getFieldErrors().stream()
        .map(e -> Map.of("field", e.getField(), "msg", e.getDefaultMessage()))
        .collect(Collectors.toList());
    return ResponseEntity.badRequest().body(Map.of("error", "validation_failed", "details", details));
  }
}
