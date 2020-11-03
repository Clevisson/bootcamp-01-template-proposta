package com.zup.proposta.request;

public class BiometriaRequest {
    private String fingerPrint;

    public BiometriaRequest(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }
}
