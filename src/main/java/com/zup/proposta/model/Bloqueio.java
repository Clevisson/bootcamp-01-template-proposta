package com.zup.proposta.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bloqueio {
    @Id
    private String id;
    private String bloqueadoEm;
    private String sistemaResponsavel;
    private Boolean ativo;

    @Deprecated
    public Bloqueio() {
    }

    public Bloqueio(String id, String bloqueadoEm, String sistemaResponsavel, Boolean ativo) {
        this.id = id;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
    }

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
