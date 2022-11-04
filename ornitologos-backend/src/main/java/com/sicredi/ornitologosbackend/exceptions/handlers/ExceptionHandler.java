package com.sicredi.ornitologosbackend.exceptions.handlers;

import com.sicredi.ornitologosbackend.exceptions.EmailJaCadastradoException;
import com.sicredi.ornitologosbackend.exceptions.SenhaInvalidaException;
import com.sicredi.ornitologosbackend.exceptions.dtos.ApiErroDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({EmailJaCadastradoException.class})
    public ResponseEntity<Object> handleUsuarioCadastradoException(RuntimeException ex, WebRequest request){

        return handleExceptionInternal(ex, new ApiErroDto(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({SenhaInvalidaException.class})
    public ResponseEntity<Object> handleSenhaInvalida(RuntimeException ex, WebRequest request){

        return handleExceptionInternal(ex, new ApiErroDto(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
