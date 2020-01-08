package com.homeproject.yourhaircare.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerConfig {

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFound() {
    }

    @ExceptionHandler(BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadRequest() {
    }

    @ExceptionHandler(AlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleAlreadyExist() {
    }

}
