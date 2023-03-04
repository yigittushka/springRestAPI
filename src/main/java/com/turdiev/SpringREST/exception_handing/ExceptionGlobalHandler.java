package com.turdiev.SpringREST.exception_handing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGlobalHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handelException (NoSuchEmployeeException exception){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage() );

        return  new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity <EmployeeIncorrectData> handelException (Exception exception){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage() );

        return  new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
