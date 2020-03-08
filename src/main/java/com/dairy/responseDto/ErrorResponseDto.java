package com.dairy.responseDto;

import com.dairy.exception.CustomException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class ErrorResponseDto {

    private String msg = null;
    private boolean status = false;
    private CustomException exception;
    private int statusCode = 404;
    Map<String,Object> extraData = new HashMap<>();
}
