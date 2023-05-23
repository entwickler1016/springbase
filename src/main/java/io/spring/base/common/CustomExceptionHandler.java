package io.spring.base.common;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Result> entityNotFoundException(EntityNotFoundException ex) {
        Result result = new Result(HttpStatus.NO_CONTENT);
        return new ResponseEntity(result, HttpStatusCode.valueOf(HttpStatus.OK.value()));
    }
}
