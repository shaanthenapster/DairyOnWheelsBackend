package com.dairy.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class ProductUploadException extends RuntimeException {

    String message;

    HttpStatus httpStatus;

    CustomException customException;

    public ProductUploadException(String message, HttpStatus httpStatus, CustomException customException){
        super(message);
        this.httpStatus = httpStatus;
        this.customException = customException;
    }

}
