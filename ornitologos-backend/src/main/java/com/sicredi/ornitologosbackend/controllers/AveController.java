package com.sicredi.ornitologosbackend.controllers;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.services.AveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/aves")
public class AveController {

    private AveService aveService;

    @GetMapping
    public ResponseEntity<List<AveDto>> listarAves(){
        List<AveDto> aveList = aveService.listarAves();
        return ResponseEntity.ok().body(aveList);
    }

    @GetMapping(value = "/{busca}")
    public ResponseEntity<AveDto> encontrarAve(@PathVariable String busca){
        AveDto aveDto = aveService.encontrarAve(busca);
        return ResponseEntity.ok().body(aveDto);
    }


    @PostMapping
    public ResponseEntity<AveDto> inserirAve(@RequestBody AveDto dto){
        dto = aveService.inserirAve(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.ok().body(dto);
    }
}
