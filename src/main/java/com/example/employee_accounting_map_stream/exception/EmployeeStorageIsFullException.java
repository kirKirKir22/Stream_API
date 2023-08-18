package com.example.employee_accounting_map_stream.exception;

public class EmployeeStorageIsFullException extends RuntimeException {

    public EmployeeStorageIsFullException(String  message) {
        super(message);
    }
}
