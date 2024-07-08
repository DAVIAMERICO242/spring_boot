package org.example.api.services;

import org.example.api.entidades.TerceiroEntidade;
import org.example.api.repositories.TerceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerceiroService {
    @Autowired
    private TerceiroRepository terceiroRepository;
    public Iterable<TerceiroEntidade> listarTerceiros(){
        return terceiroRepository.findAll();
    }
    public Iterable<TerceiroEntidade> terceiroByState(String state){
        return terceiroRepository.findByEstado(state);
    }
}
