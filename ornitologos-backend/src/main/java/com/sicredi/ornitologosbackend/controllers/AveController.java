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
@RequestMapping(path = "/v1/aves")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AveController {

    private final AveService aveService;

    @GetMapping
    public ResponseEntity<Page<AveDto>> encontrarAve(@RequestParam(value = "q",required = false,defaultValue = "") String filtro,
                                                     @PageableDefault(page=0, size=4, sort = "nomePt", direction = Sort.Direction.ASC) Pageable pageable){
        Page<AveDto> aveDto = aveService.encontrarAves(filtro, pageable);
            return ResponseEntity.ok().body(aveDto);
    }
    @PostMapping(path = "/adicionar")
    public ResponseEntity<AveDto> inserirAve(@RequestBody AveDto dto){
        dto = aveService.inserirAve(dto);
        return ResponseEntity.ok().body(dto);
    }
}
