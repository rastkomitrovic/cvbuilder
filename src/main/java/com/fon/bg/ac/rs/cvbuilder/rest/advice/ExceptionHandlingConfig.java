package com.fon.bg.ac.rs.cvbuilder.rest.advice;

import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlingConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CVBuilderException.class})
    protected ResponseEntity<Object> handleCvBuilderException(CVBuilderException ex, WebRequest webRequest) {
        ex.printStackTrace();
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("message","Greska u zahtevu");
        body.put("errors", Arrays.asList(ex.getMessages()));
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler(value = {EmptyResultDataAccessException.class})
    protected ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest webRequest) {
        ex.printStackTrace();
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("message","Ne postoji entitet sa prosledjenim ID-om");
        body.put("errors",Arrays.asList(ex.getMessage()));
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }

    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
    protected ResponseEntity<Object> handleSqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex, WebRequest webRequest) {
        ex.printStackTrace();
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("message","Nemoguce je izvrsiti operaciju zbog integriteta podataka nad bazom");
        body.put("errors", Arrays.asList(ex.getMessage()));
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, webRequest);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        body.put("message","Greska u parametrima API poziva");
        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);
    }
}
