package com.sicredi.ornitologosbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailNaoEncontradoException  extends RuntimeException{

    private final String message = "Email não encontrado,tente novamente!";

    public EmailNaoEncontradoException() {
        super("Email não encontrado,tente novamente!");
    }

    @Override
    public String getMessage() {
        return message;
    }
}
