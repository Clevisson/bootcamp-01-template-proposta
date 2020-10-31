package com.zup.proposta.response;

import com.zup.proposta.model.*;

public class RespostaCriaCartaoResponse {
    String id;
    String emitidoEm;
    String titular;
    Bloqueio bloqueios;
    AvisoViagem avisos;
    Carteiras carteiras;
    Parcela parcela;
    int limite;
    Renegociacao renegociacao;
    Vencimento vencimento;
    String idProposta;

    public RespostaCriaCartaoResponse(String id,
                                      String emitidoEm,
                                      String titular,
                                      Bloqueio bloqueios,
                                      AvisoViagem avisos,
                                      Carteiras carteiras,
                                      Parcela parcela,
                                      int limite,
                                      Renegociacao renegociacao,
                                      Vencimento vencimento,
                                      String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcela = parcela;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
        this.idProposta = idProposta;
    }

    public String getId() {
        return id;
    }

    public String getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public Bloqueio getBloqueios() {
        return bloqueios;
    }

    public AvisoViagem getAvisos() {
        return avisos;
    }

    public Carteiras getCarteiras() {
        return carteiras;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public int getLimite() {
        return limite;
    }

    public Renegociacao getRenegociacao() {
        return renegociacao;
    }

    public Vencimento getVencimento() {
        return vencimento;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
