package com.zup.proposta.request;

public class CartaoBloqueadoRequest {

    private String sistemaResponsavel;

    @Deprecated
    public CartaoBloqueadoRequest() {
    }

    public CartaoBloqueadoRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public void setSistemaResponsavel(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }
}
