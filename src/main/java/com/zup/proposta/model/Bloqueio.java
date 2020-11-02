package com.zup.proposta.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Bloqueio {
    @Column(name = "id_bloqueio", insertable = false, updatable = false)
    String id;
    String bloqueadoEm;
    @Column(name = "sistema_responsavel_bloqueio")
    String sistemaResponsavel;
    @Column(name = "bloqueio_ativo")
    Boolean ativo;
}
