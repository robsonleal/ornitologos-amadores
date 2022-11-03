package com.sicredi.ornitologosbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class SenhaInvalidaException extends RuntimeException{

    private  final String message = "Senha inválida,tente novamente!";

    public SenhaInvalidaException() {
       super("Senha inválida,tente novamente!");
    }

    @Override
    public String getMessage() {
        return message;
    }
}
