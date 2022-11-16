package com.sicredi.ornitologosbackend.controllers;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.services.AveServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/aves")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AveController {
    private final AveServiceImpl aveServiceImpl;
    @GetMapping
    public ResponseEntity<Page<AveDto>> encontrarAve(@RequestParam(value = "q",required = false,defaultValue = "") String filtro,
                                                     @PageableDefault(page=0, size=4, sort = "nomePt", direction = Sort.Direction.ASC) Pageable pageable){
        Page<AveDto> aveDto = aveServiceImpl.encontrarAves(filtro, pageable);
            return ResponseEntity.ok().body(aveDto);
    }
    @PostMapping
    public ResponseEntity<AveDto> inserirAve(@RequestBody AveDto dto){
        return ResponseEntity.ok().body(aveServiceImpl.inserirAve(dto));
    }
}
