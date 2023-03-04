package com.turdiev.SpringREST.exception_handing;

public class NoSuchEmployeeException  extends RuntimeException{
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
