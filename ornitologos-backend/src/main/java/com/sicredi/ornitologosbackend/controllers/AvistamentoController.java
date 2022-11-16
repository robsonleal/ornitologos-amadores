package com.sicredi.ornitologosbackend.controllers;


import com.sicredi.ornitologosbackend.dtos.AvistamentoDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioDto;
import com.sicredi.ornitologosbackend.entities.Avistamento;
import com.sicredi.ornitologosbackend.kafka.AvistamentoProducer;
import com.sicredi.ornitologosbackend.services.AvistamentoServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

@RestController
@RequestMapping(value="/avistamentos")
@RequiredArgsConstructor
public class AvistamentoController {

    private final AvistamentoServiceImp avistamentoServiceImp;
    private final AvistamentoProducer avistamentoProducer;

    @GetMapping
    public ResponseEntity <Set<Avistamento>> listarTodos(@AuthenticationPrincipal UsuarioDto usuario) {//retorna objeto encapsulado
        return ResponseEntity.ok().body(avistamentoServiceImp.listarTodos(usuario.getId()));
    }

    @PostMapping
    public ResponseEntity<AvistamentoDto> inserirAvistamento(@RequestBody AvistamentoDto avistamentoDto) throws URISyntaxException {
        avistamentoProducer.enviarAvistamento(avistamentoDto);

        return ResponseEntity.created(new URI(String.format("/avistamentos/%d",
                        avistamentoDto.getId())))
                .body(avistamentoDto);
    }
}
