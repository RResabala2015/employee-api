package com.employee.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.FieldError;


/**
 * Wraps all exceptions thrown during any integration call to teams APIs
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandling {


    /**
     * Wrap All MethodArgumentNotValidException  Exception
     *
     * @param exception identifies unique contact
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValidException(
        final MethodArgumentNotValidException exception
    ) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(
            (FieldError error) -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

}