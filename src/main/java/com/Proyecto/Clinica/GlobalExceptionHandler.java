package com.Proyecto.Clinica;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> todosErrores(Exception e, WebRequest r){
        logger.error(e.getMessage());
        return new ResponseEntity("Error" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
