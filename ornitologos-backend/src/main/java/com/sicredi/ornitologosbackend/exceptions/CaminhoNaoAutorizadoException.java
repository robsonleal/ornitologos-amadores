package com.sicredi.ornitologosbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CaminhoNaoAutorizadoException extends RuntimeException {


    private final String  message ="Caminho não autorizado!";

    public CaminhoNaoAutorizadoException() {
        super("Caminho não autorizado!");
    }

    @Override
    public String getMessage() {
        return message;
    }
}
