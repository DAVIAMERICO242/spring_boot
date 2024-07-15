package org.example.api.terceiros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
