package de.dwosch.energydrinkservice.controller;

import de.dwosch.energydrinkservice.exceptions.AlreadyExistsException;
import de.dwosch.energydrinkservice.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * danielwosch created on 2020-05-24
 */
@RestControllerAdvice
public class ExceptionRestControllerAdvice {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(final HttpServletRequest request, final NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AlreadyExistsException.class)
    public ResponseEntity<String> handleAlreadyExistsException(final HttpServletRequest request, final AlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
