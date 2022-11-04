package com.sicredi.ornitologosbackend.exceptions.handlers;

import com.sicredi.ornitologosbackend.exceptions.EmailJaCadastradoException;
import com.sicredi.ornitologosbackend.exceptions.SenhaInvalidaException;
import com.sicredi.ornitologosbackend.exceptions.dtos.ApiErroDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({EmailJaCadastradoException.class})
    public ResponseEntity<Object> handleEmailCadastradoException(RuntimeException ex, WebRequest request){

        return handleExceptionInternal(ex, new ApiErroDto(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({SenhaInvalidaException.class})
    public ResponseEntity<Object> handleSenhaInvalidaException(RuntimeException ex, WebRequest request){

        return handleExceptionInternal(ex, new ApiErroDto(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ApiErroDto> erros = gerarErros(ex.getBindingResult());

        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }



    private List<ApiErroDto> gerarErros(BindingResult bindingResult) {

        List<ApiErroDto> erros = new ArrayList<ApiErroDto>();

        bindingResult.getFieldErrors().forEach(fieldError -> {
            String message = fieldError.getDefaultMessage();
            erros.add(new ApiErroDto(message));
        });

        return erros;
    }
}
