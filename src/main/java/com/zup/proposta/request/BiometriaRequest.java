package com.zup.proposta.request;

import com.zup.proposta.model.Biometria;
import com.zup.proposta.model.Cartao;
import com.zup.proposta.validations.ValidaBase64;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class BiometriaRequest {
    @NotBlank
    private String idCartao;
    @ValidaBase64
    private String fingerPrint;

    public BiometriaRequest(@NotBlank String idCartao, String fingerPrint) {
        this.idCartao = idCartao;
        this.fingerPrint = fingerPrint;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }
    public Biometria toModel(EntityManager manager){
        return new Biometria(manager.find(Cartao.class, idCartao), fingerPrint);
    }
}
