package com.sicredi.ornitologosbackend.controllers;


import com.sicredi.ornitologosbackend.dtos.AvistamentoDto;
import com.sicredi.ornitologosbackend.entities.Avistamento;
import com.sicredi.ornitologosbackend.services.AvistamentoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/avistamentos")
public class AvistamentoController {

    @Autowired
    private AvistamentoServiceImp avistamentoServiceImp;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<Avistamento>> listarTodos() {//retorna objeto encapsulado
        List<Avistamento> list = avistamentoServiceImp.listarTodos();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirAvistamento(@RequestBody AvistamentoDto avistamentoDto) {
        Avistamento avistamento = avistamentoServiceImp.converteDoDTO(avistamentoDto);
        avistamento = avistamentoServiceImp.inserirAvistamento(avistamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avistamento.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
