package org.example.api.services;

import lombok.AllArgsConstructor;
import org.example.api.DTOS.TerceiroDTO;
import org.example.api.entidades.TerceiroEntidade;
import org.example.api.repositories.TerceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerceiroService {
    @Autowired
    private TerceiroRepository terceiroRepository;

    public boolean checkExistenceById(String cnpj_cpf){
        return terceiroRepository.findById(cnpj_cpf).isPresent();
    }

    public Iterable<TerceiroEntidade> listarTerceiros(){
        return terceiroRepository.findAll();
    }

    public TerceiroEntidade createTerceiro(TerceiroEntidade terceiro){
        return terceiroRepository.save(terceiro);
    }

    public TerceiroEntidade updateTerceiro(TerceiroEntidade terceiro){
        return terceiroRepository.save(terceiro);
    }

    public Boolean deleteTerceiro(String cnpj_cpf){
        terceiroRepository.deleteById(cnpj_cpf);
        return true;
    }
}
