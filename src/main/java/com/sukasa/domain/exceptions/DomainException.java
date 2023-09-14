package com.sukasa.domain.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainException extends RuntimeException{
     private final HttpStatus httpStatus;

    public DomainException(String message, HttpStatus httpStatus)
    {
        super(message);
        this.httpStatus = httpStatus;
    }

    public DomainException(String message, HttpStatus httpStatus, Exception innerException)
    {
        super(message, innerException);
        this.httpStatus = httpStatus;
    }

    public DomainException(String message) {
        super(message);
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
