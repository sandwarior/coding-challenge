package com.codingchallenge.controllers;

import com.codingchallenge.exception.ClientConnectionRefusedException;
import com.codingchallenge.exception.GenericExceptionObject;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


public class BaseController {


    @ExceptionHandler(ClientConnectionRefusedException.class)
    public ResponseEntity<Object> handleClientConnectionRefusedException(ClientConnectionRefusedException ex) {
        return ResponseEntity.internalServerError().body(new GenericExceptionObject().message(ex.getMessage()));
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class,ConversionFailedException.class})
        public ResponseEntity<Object> handleExceptionsForBadRequests(MethodArgumentTypeMismatchException ex) {
            return ResponseEntity.badRequest().body(new GenericExceptionObject().message(ex.getMessage()));
        }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.internalServerError().body(new GenericExceptionObject().message(ex.getMessage()));
    }
}
