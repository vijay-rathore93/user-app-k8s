package com.vijaycode.exception;


import com.vijaycode.model.ErrorResponseDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class UserExceptionHandlerAdvise {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponseDO> handleException(UserException exception) {
        ErrorResponseDO response = ErrorResponseDO.builder().errorMessage(exception.getExceptionMessage()).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDO> handleException(Exception exception) {
        ErrorResponseDO response = ErrorResponseDO.builder().errorMessage(exception.getMessage()).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
