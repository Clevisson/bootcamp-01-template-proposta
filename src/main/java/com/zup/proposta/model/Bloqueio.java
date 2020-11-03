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

    public String getId() {
        return id;
    }

    public String getBloqueadoEm() {
        return bloqueadoEm;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBloqueadoEm(String bloqueadoEm) {
        this.bloqueadoEm = bloqueadoEm;
    }

    public void setSistemaResponsavel(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
