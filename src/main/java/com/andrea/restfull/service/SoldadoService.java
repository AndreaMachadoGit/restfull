package com.andrea.restfull.service;

import com.andrea.restfull.controller.request.SoldadoEditRequest;
import com.andrea.restfull.controller.response.SoldadoResponse;
import com.andrea.restfull.dto.Soldado;
import com.andrea.restfull.entity.SoldadoEntity;
import com.andrea.restfull.repository.SoldadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoldadoService {

    private SoldadoRepository soldadoRepository;
    private ObjectMapper objectMapper;

    public SoldadoService(SoldadoRepository soldadoRepository, ObjectMapper objectMapper) {
        this.soldadoRepository = soldadoRepository;
        this.objectMapper = objectMapper;
    }

    public SoldadoResponse buscarSoldado(Long id) {
        SoldadoEntity soldado = soldadoRepository.findById(id).orElseThrow();
        SoldadoResponse soldadoResponse = objectMapper.convertValue(soldado, SoldadoResponse.class);
        return soldadoResponse;
    }

    public void criarSoldado(Soldado soldado){
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldado, SoldadoEntity.class);
        soldadoRepository.save(soldadoEntity);
    }

    public void alterarSoldado(Long id, SoldadoEditRequest soldadoEditRequest) {
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldadoEditRequest, SoldadoEntity.class);
        soldadoEntity.setId(id);
        soldadoRepository.save(soldadoEntity);
    }

    public void deletarSoldado(Long id) {
        SoldadoEntity soldado = soldadoRepository.findById(id).orElseThrow();
        soldadoRepository.delete(soldado);
    }

    public List<Soldado> buscarSoldados(){
        List<SoldadoEntity> all = soldadoRepository.findAll();
        List<Soldado> soldadoStream = all.stream()
                .map(it -> objectMapper.convertValue(it, Soldado.class))
                .collect(Collectors.toList());
        return soldadoStream;
    }}
