package com.zup.proposta;

public class RespostaAvaliacaoResponse {
    private String documento;
    private String resultadoSolicitacao;
    private String idProposta;

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

