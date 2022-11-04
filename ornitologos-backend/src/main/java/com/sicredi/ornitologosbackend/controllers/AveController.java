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

@RestController(value = "/aves")
@RequiredArgsConstructor
public class AveController {

    private final AveService aveService;

    @GetMapping(value = "{busca}")
    public ResponseEntity<List<Ave>> encontrarAve(@PathVariable String busca){
        List<Ave> aveList = aveService.encontrarAve(busca);
        return ResponseEntity.ok().body(aveList);
    }


    @PostMapping("/add")
    public ResponseEntity<AveDto> inserirAve(@RequestBody AveDto dto){
        dto = aveService.inserirAve(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.ok().body(dto);
    }
}
