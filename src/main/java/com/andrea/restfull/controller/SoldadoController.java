package com.andrea.restfull.controller;


import com.andrea.restfull.controller.request.SoldadoEditRequest;
import com.andrea.restfull.controller.response.SoldadoResponse;
import com.andrea.restfull.dto.Soldado;
import com.andrea.restfull.service.SoldadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    //@Autowired
    private SoldadoService soldadoService;
    private ObjectMapper objectMapper;

    public SoldadoController(SoldadoService soldadoService, ObjectMapper objectMapper) {
        this.soldadoService = soldadoService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldadoResponse> buscarSoldado(@PathVariable("id") Long id) {
        SoldadoResponse soldadoResponse = soldadoService.buscarSoldado(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldadoResponse);
    }

    @GetMapping
    public ResponseEntity<List<SoldadoResponse>> buscarSoldados() {
        List<SoldadoResponse> soldados = soldadoService.buscarSoldados().stream()
                .map(it -> objectMapper.convertValue(it, SoldadoResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(soldados);
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado){
        soldadoService.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity editarSoldado(@PathVariable("id") Long id,
                                        @RequestBody SoldadoEditRequest soldadoEditRequest){
        soldadoService.alterarSoldado(id,soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarSoldado(@PathVariable("id") Long id){
        soldadoService.deletarSoldado(id);
        return ResponseEntity.ok().build();
    }


}
