package com.zup.proposta.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parcela {
    @Id
    private String id;
    private Integer quartidade;
    private Number valor;

    @Deprecated
    public Parcela() {
    }

    public Parcela(String id, Integer quartidade, Number valor) {
        this.id = id;
        this.quartidade = quartidade;
        this.valor = valor;
    }
}
