package poc.sb.codefirst.oas30.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import poc.sb.codefirst.oas30.exception.InvalidCommandException;
import poc.sb.codefirst.oas30.exception.EntityNotFoundException;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(InvalidCommandException.class)
    public ResponseEntity<String> handle(InvalidCommandException e) {
        return ResponseEntity
                .status(UNPROCESSABLE_ENTITY)
                .contentType(APPLICATION_JSON)
                .body("{\"message\":\"" + e.getMessage() + "\"}");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handle(EntityNotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND)
                .contentType(APPLICATION_JSON)
                .body("{\"message\":\"" + e.getMessage() + "\"}");
    }
}
