package com.dairy.responseDto;

import com.dairy.enums.SuccessCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponseDto {

    private boolean status = true;
    private SuccessCodes successCode;
    private int statusCode = 200;
    private Map<String, Object> extraData = new HashMap<>();

}
