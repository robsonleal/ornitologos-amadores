package com.sicredi.ornitologosbackend.controllers;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.services.AveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/aves")
public class AveController {

    @Autowired
    private AveService aveService;

    @GetMapping(path = "/listar")
    public ResponseEntity<Page<AveDto>> listarAves(@RequestParam(value = "token") String aves,
            @PageableDefault(page=0, size=3, sort = "nomePt", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<AveDto> allAves = aveService.listarAves(pageable);
        return ResponseEntity.ok().body(allAves);
    }

    @GetMapping(path = "/{busca}")
    public ResponseEntity<Page<AveDto>> encontrarAve(@PathVariable("busca") String busca, @PageableDefault(page=0, size=3, sort = "nomePt", direction = Sort.Direction.ASC) Pageable pageable){
        Page<AveDto> aveDto = aveService.encontrarAves(busca, pageable);
            return ResponseEntity.ok().body(aveDto);
    }

    @PostMapping(path = "/adicionar")
    public ResponseEntity<AveDto> inserirAve(@RequestBody AveDto dto){
        dto = aveService.inserirAve(dto);
        return ResponseEntity.ok().body(dto);
    }
}
