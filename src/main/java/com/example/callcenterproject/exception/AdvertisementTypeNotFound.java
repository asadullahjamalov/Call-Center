package com.example.callcenterproject.exception;

import com.example.callcenterproject.model.ExceptionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdvertisementTypeNotFound extends RuntimeException {
    private ExceptionResponse exceptionResponse;
}