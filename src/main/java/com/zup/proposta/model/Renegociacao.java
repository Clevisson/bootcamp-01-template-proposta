package com.zup.proposta.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Renegociacao {
    @Id
    private String id;
    private Integer quartidade;
    private Number valor;
    private LocalDateTime dataCriacao;

    @Deprecated
    public Renegociacao() {
    }

    public Renegociacao(String id,
                        Integer quartidade,
                        Number valor,
                        LocalDateTime dataCriacao) {
        this.id = id;
        this.quartidade = quartidade;
        this.valor = valor;
        this.dataCriacao = dataCriacao;
    }
}
