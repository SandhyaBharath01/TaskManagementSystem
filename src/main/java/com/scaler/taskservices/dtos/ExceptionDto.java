package com.scaler.taskservices.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionDto {
    private String message;
    private String solution;
    private Long id;
}
