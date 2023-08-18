package com.example.employee_accounting_map_stream.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "вводите только буквы")
public class IllegalNameException extends IllegalArgumentException {


}
