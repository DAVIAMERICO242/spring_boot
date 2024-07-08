package org.example.api.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "terceiros")
public class TerceiroEntidade {
    @Id
    private String cnpj_cpf;
    private String nome;
    private String tipo;
    private String estado;
}
