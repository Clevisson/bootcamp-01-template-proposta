package com.zup.proposta.response;

public class CartaoBloqueadoResponse {
    private String resultado;

    @Deprecated
    public CartaoBloqueadoResponse() {
    }

    public CartaoBloqueadoResponse(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }
}
