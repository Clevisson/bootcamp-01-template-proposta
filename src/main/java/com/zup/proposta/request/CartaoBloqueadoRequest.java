package com.zup.proposta.request;

public class CartaoBloqueadoRequest {

    private String sistemaResponsavel;

    public CartaoBloqueadoRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    @Deprecated
    public CartaoBloqueadoRequest() {
    }
}
