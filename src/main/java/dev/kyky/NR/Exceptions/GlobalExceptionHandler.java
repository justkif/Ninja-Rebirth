package dev.kyky.NR.Exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NinjaConflictException.class)
    public ResponseEntity<String> handleNinjaConflict(NinjaConflictException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(NinjaNotFoundException.class)
    public ResponseEntity<String> handleNinjaNotFound(NinjaNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(UserConflictException.class)
    public ResponseEntity<String> handleUserConflict(UserConflictException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(UserUnauthorizedException.class)
    public ResponseEntity<String> handleUserUnauthorized(UserUnauthorizedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request.");
    }

}
