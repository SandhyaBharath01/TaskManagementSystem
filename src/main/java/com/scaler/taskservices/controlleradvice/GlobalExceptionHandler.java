package com.scaler.taskservices.controlleradvice;

import com.scaler.taskservices.dtos.ExceptionDto;
import com.scaler.taskservices.exceptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //Arithmetic Exception
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("ArithmeticException has Happened");
        exceptionDto.setSolution("Please try again");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
        return response;
    }
    //Array Index Out Of Bound Exception
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException() {
        ResponseEntity<String> response = new ResponseEntity<>(
                "ArrayIndexOutOfBoundsException has Happened, in controllerAdvice",
                HttpStatus.BAD_REQUEST
        );
        return response;
    }
    //Task Not found Exception
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleTaskNotFoundException(TaskNotFoundException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Task Not Found");
//        exceptionDto.setId();
        exceptionDto.setId(ex.getTaskId());
        exceptionDto.setSolution("Try again with another TaskId");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
        return response;
    }

}
