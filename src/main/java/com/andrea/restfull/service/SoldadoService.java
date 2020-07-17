package com.andrea.restfull.service;

import com.andrea.restfull.controller.request.SoldadoEditRequest;
import com.andrea.restfull.dto.Soldado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldadoService {
    public Soldado buscarSoldado(String cpf) {
        Soldado soldado = new Soldado();
        soldado.setCpf(cpf);
        soldado.setNome("Andrea");
        soldado.setRaca("Elfo");
        soldado.setArma("Machado");
        return soldado;
    }

    public void criarSoldado(Soldado soldado) {

    }

    public void alterarSoldado(String cpf, SoldadoEditRequest soldadoEditRequest) {

    }

    public void deletarSoldado(String cpf) {

    }

    public List<Soldado> findAll() {
        return null;
    }

}
