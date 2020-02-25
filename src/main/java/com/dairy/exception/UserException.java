package com.dairy.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Setter
@Getter
public class UserException extends Exception {

    private static final long serialVersionUID = 1375729682591813893L;

    private List<String> str;

    private CustomException exception;

    public UserException(String err, CustomException customException) {
        super(err);
        this.exception = customException;
    }
}
