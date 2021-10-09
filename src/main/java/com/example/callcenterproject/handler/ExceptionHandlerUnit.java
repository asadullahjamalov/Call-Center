package com.example.callcenterproject.handler;

import com.example.callcenterproject.exception.OperatorNotFound;
import com.example.callcenterproject.exception.UsernameIsNotUnique;
import com.example.callcenterproject.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerUnit {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(OperatorNotFound.class)
    public ExceptionResponse handleAgentNotFoundException(OperatorNotFound ex){
        return ex.getExceptionResponse();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameIsNotUnique.class)
    public ExceptionResponse handleOfferWasAlreadySentException(UsernameIsNotUnique ex){
        return ex.getExceptionResponse();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleUnexpectedError(Exception ex){
        return new ExceptionResponse(ex.getMessage(),500);
    }
}
