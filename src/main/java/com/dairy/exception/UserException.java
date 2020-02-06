package com.dairy.exception;

import java.util.List;

public class UserException extends Exception {

    private static final long serialVersionUID = 1375729682591813893L;

    private List<String> str;

    private CustomException exception;

    public UserException(String err, CustomException customException) {
        super(err);
        this.exception = customException;
    }
}
