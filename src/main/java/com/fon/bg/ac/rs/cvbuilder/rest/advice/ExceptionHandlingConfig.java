package com.fon.bg.ac.rs.cvbuilder.rest.advice;

import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CVBuilderException.class})
    protected ResponseEntity<Object> handleCvBuilderException(CVBuilderException ex, WebRequest webRequest){
        return handleExceptionInternal(ex,"Greska u zahtevu: "+ex.getMessage(),new HttpHeaders(), HttpStatus.BAD_REQUEST,webRequest);
    }
}
