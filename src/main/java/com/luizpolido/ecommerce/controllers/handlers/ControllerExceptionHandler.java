package com.luizpolido.ecommerce.controllers.handlers;


import com.luizpolido.ecommerce.dto.CustomErrorDTO;
import com.luizpolido.ecommerce.dto.FieldMessage;
import com.luizpolido.ecommerce.dto.ValidationError;
import com.luizpolido.ecommerce.services.exceptions.DatabaseException;
import com.luizpolido.ecommerce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorDTO> resourceNotFound(ResourceNotFoundException e , HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomErrorDTO err = new CustomErrorDTO(Instant.now() , status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomErrorDTO> databaseReferenceIntegrityFail(DatabaseException e , HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST; // Conflict pode funcionar tambem
        CustomErrorDTO err = new CustomErrorDTO(Instant.now() , status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorDTO> methodArgumentNotValid(MethodArgumentNotValidException e , HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError(Instant.now() , status.value(), e.getMessage(), request.getRequestURI());

        for (FieldError f: e.getBindingResult().getFieldErrors()){
            err.addError(f.getField() , f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }
}

