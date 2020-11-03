package com.zup.proposta.response;

public class RespostaAvaliacaoResponse {
    private final String documento;
    private final String resultadoSolicitacao;
    private final String idProposta;

    public RespostaAvaliacaoResponse(String documento, String resultadoSolicitacao, String idProposta) {
        this.documento = documento;
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
    }

    public String getDocumento() {
        return documento;
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public String getIdProposta() {
        return idProposta;
    }

}

