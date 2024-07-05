package com.example.corebank.exception;

import lombok.Data;

@Data
public class AgeException extends RuntimeException {
    public AgeException(){ }
    public AgeException(String message) {
        super(message);
    } 
    public AgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgeException(Throwable cause) {
        super(cause);
    }

   
}
