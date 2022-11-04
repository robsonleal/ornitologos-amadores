package com.sicredi.ornitologosbackend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailJaCadastradoException extends RuntimeException {

    private final String  message ="Email já foi cadastrado,tente novamente!";

    public EmailJaCadastradoException() {
        super("Email já foi cadastrado,tente novamente!");
    }

    @Override
    public String getMessage() {
        return message;
    }
}
