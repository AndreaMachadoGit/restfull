package com.andrea.restfull.controller;

import com.andrea.restfull.controller.request.SoldadoEditRequest;
import com.andrea.restfull.controller.response.SoldadoListResponse;
import com.andrea.restfull.controller.response.SoldadoResponse;
import com.andrea.restfull.dto.Soldado;
import com.andrea.restfull.service.SoldadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

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
    public ResponseEntity<CollectionModel<SoldadoListResponse>> buscarSoldados() {
        CollectionModel<SoldadoListResponse> soldadoListResponses = soldadoService.buscarSoldados();
        return ResponseEntity.status(HttpStatus.OK).body(soldadoListResponses);
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

    @PutMapping("/frenteCastelo/{id}")
    public ResponseEntity frenteCastelo(@PathVariable("id") Long id){
        //soldadoService.deletarSoldado(id);
        return ResponseEntity.ok().build();
    }

}
