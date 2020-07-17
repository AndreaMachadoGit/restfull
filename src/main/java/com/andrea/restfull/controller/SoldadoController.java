package com.andrea.restfull.controller;


import com.andrea.restfull.controller.request.SoldadoEditRequest;
import com.andrea.restfull.dto.Soldado;
import com.andrea.restfull.service.SoldadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    //@Autowired
    private SoldadoService soldadoService;

    @GetMapping
    public ResponseEntity<List<Soldado>> buscarSoldado() {
        List<Soldado> soldados = soldadoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(soldados);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Soldado> buscarSoldado(@PathVariable("cpf") String cpf) {
        Soldado soldado = soldadoService.buscarSoldado(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(soldado);
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado){
        soldadoService.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity editarSoldado(@PathVariable("cpf") String cpf,
                                        @RequestBody SoldadoEditRequest soldadoEditRequest){
        soldadoService.alterarSoldado(cpf,soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarSoldado(@PathVariable("cpf") String cpf){
        soldadoService.deletarSoldado(cpf);
        return ResponseEntity.ok().build();
    }


}
