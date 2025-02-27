package org.example.api.terceiros;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "terceiros")
@Entity(name="terceiros")
@Getter
@EqualsAndHashCode
public class TerceiroEntidade {
    @Id
    private String cnpj_cpf;
    private String nome;
    private String tipo;
    private String estado;
}
