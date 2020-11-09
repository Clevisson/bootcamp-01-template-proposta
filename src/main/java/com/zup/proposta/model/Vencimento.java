package com.zup.proposta.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Vencimento {
    @Id
    private String id;
    private Integer dia;
    private LocalDateTime dataCriacao;

    @Deprecated
    public Vencimento() {
    }

    public Vencimento(String id,
                      Integer dia,
                      LocalDateTime dataCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataCriacao = dataCriacao;
    }

    public String getId() {
        return id;
    }

    public Integer getDia() {
        return dia;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
