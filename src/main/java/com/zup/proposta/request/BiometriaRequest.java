package com.zup.proposta.request;

import com.zup.proposta.model.Biometria;

import javax.validation.constraints.NotBlank;
import java.util.Base64;

public class BiometriaRequest {
    @NotBlank
    private String fingerPrint;

    @Deprecated
    public BiometriaRequest() {
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public Biometria toModel(String idCartao, String fingerPrint) {
        return new Biometria(idCartao, fingerPrint);
    }

    public Boolean isBase64(String fingerPrint) {
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            decoder.decode(fingerPrint);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
