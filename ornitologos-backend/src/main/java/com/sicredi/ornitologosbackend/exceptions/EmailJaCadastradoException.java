package com.sicredi.ornitologosbackend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EmailJaCadastradoException extends RuntimeException {

    private  String  message ="Email já foi cadastrado,tente novamente!";

    public EmailJaCadastradoException() {
        super("Email já foi cadastrado,tente novamente!");
    }
    public String getMessage() {
        return message;
    }
}
