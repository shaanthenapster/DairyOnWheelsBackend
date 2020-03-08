package com.dairy.api;

import com.dairy.exception.CustomException;
import com.dairy.exception.ProductUploadException;
import com.dairy.exception.UserException;
import com.dairy.responseDto.ErrorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(UserException.class)
    ResponseEntity<Object> userException(final UserException uonf){
        ErrorResponseDto err = new ErrorResponseDto();
        err.setException(uonf.getException());
//        err.getMsg().add(uonf.getMessage());
        return ResponseEntity.ok().body(err);
    }

    @ExceptionHandler(ProductUploadException.class)
    ResponseEntity<Object> productUploadException(final ProductUploadException e){
        ErrorResponseDto err = new ErrorResponseDto();
        err.setException(e.getCustomException());
        err.setStatusCode(e.getHttpStatus().value());
        err.setMsg(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(err);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<Object> notFoundException(final Exception unfe) {
        ErrorResponseDto err = new ErrorResponseDto();
        err.setException(CustomException.FATAL_EXCEPTION);
//        err.getMsg().add(unfe.getMessage());
        unfe.printStackTrace();
        return ResponseEntity.ok().body(err);
    }
}
