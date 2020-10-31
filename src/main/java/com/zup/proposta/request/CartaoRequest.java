package com.zup.proposta.request;

import com.zup.proposta.model.Proposta;

import java.util.UUID;

public class CartaoRequest {
    String documento;
    String nome;
    UUID idProposta;

    @Deprecated
    public CartaoRequest() {
    }

    public CartaoRequest(String documento, String nome, UUID idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }

    public CartaoRequest(Proposta proposta) {
        this.documento = proposta.getDocumento();
        this.idProposta = proposta.getId();
        this.nome = proposta.getNome();
    }


    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public UUID getIdProposta() {
        return idProposta;
    }
}
