package org.example.api.repositories;
import org.example.api.entidades.TerceiroEntidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerceiroRepository extends CrudRepository<TerceiroEntidade, String>{
    List<TerceiroEntidade> findByEstado(String estado);//adicional, tradicinalmente so aceita pelo id
}
