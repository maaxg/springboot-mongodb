package com.example.maaxg.workshopmongo.resources.exception;

import com.example.maaxg.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

//Isso indica que essa classe irá tratar possiveis erros em algumas requisições
@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not Found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
