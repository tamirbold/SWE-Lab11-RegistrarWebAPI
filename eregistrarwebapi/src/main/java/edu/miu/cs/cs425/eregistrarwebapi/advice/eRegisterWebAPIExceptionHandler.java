package edu.miu.cs.cs425.eregistrarwebapi.advice;

import java.util.HashMap;
import java.util.Map;

import edu.miu.cs.cs425.eregistrarwebapi.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class eRegisterWebAPIExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String, String> handleWebAPIException(StudentNotFoundException studentNotFoundException) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", studentNotFoundException.getMessage());
        return errorMap;
    }
}
