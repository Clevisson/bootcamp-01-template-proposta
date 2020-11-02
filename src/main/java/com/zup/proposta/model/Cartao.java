package com.zup.proposta.model;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {
    @Id
    private String id;
    private String emitidoEm;
    private String titular;
    @Embedded
    private Bloqueio bloqueios;
    @Embedded
    private AvisoViagem avisos;
    @Embedded
    private Carteiras carteiras;
    @Embedded
    private Parcela parcela;
    private int limite;
    @Embedded
    private Renegociacao renegociacao;
    @Embedded
    private Vencimento vencimento;
    private String idProposta;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id,
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
}
