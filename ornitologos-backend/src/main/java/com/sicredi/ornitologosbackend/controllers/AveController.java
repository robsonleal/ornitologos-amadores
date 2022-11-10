package com.sicredi.ornitologosbackend.controllers;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.services.AveService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/aves")
public class AveController {

    @Autowired
    private AveService aveService;

    @GetMapping
    public ResponseEntity<Page<List<Ave>>> listarAves(@RequestParam(value = "aves") String aves,
            @PageableDefault(page=0, size=3, sort = "nomePt", direction = Sort.Direction.ASC) Pageable pageable){
//        Page<List<AveDto>> aveList = aveService.listarAves(aves, pageable);
        return ResponseEntity.ok().body(aveService.listarAves(pageable));
    }

    @GetMapping(path = "/{busca}")
    public ResponseEntity<List<AveDto>> encontrarAve(@PathVariable("busca") String busca, @PageableDefault(page=0, size=3, sort = "nomePt", direction = Sort.Direction.ASC) Pageable pageable){
        List<AveDto> aveDto = aveService.encontrarAves(busca, pageable);
        return ResponseEntity.ok().body(aveDto);
    }


    @PostMapping(path = "/adicionar")
    public ResponseEntity<AveDto> inserirAve(@RequestBody AveDto dto){
        dto = aveService.inserirAve(dto);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.ok().body(dto);
    }
}
