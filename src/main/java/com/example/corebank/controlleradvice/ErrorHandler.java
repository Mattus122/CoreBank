package com.example.corebank.controlleradvice;

import com.example.corebank.dto.ErrorObject;
import com.example.corebank.exception.AgeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(AgeException.class)
    public ResponseEntity<ErrorObject> exception(AgeException e){
        ErrorObject er  = ErrorObject.builder().message(e.getMessage()).timestamp(System.currentTimeMillis()).status(HttpStatus.CONFLICT.value()).build();
        return new ResponseEntity<>(er , HttpStatus.CONFLICT);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleExcetion(Exception e){
        ErrorObject er = ErrorObject.builder().message(e.getMessage()).status(HttpStatus.BAD_REQUEST.value()).timestamp(System.currentTimeMillis()).build();
        return new ResponseEntity<>(er , HttpStatus.BAD_REQUEST);
    }
}
