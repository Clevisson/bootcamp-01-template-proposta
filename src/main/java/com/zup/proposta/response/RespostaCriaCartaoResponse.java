package com.zup.proposta.response;

import com.zup.proposta.model.*;

import java.util.Set;

public class RespostaCriaCartaoResponse {
    private String id;
    private String emitidoEm;
    private String titular;
    private Set<Bloqueio> bloqueios;
    private Set<AvisoViagem> avisos;
    private Set<Carteiras> carteiras;
    private Set<Parcela> parcela;
    private int limite;
    private Renegociacao renegociacao;
    private Vencimento vencimento;
    private String idProposta;

    public RespostaCriaCartaoResponse(String id,
                                      String emitidoEm,
                                      String titular,
                                      Set<Bloqueio> bloqueios,
                                      Set<AvisoViagem> avisos,
                                      Set<Carteiras> carteiras,
                                      Set<Parcela> parcela,
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

    public Set<Bloqueio> getBloqueios() {
        return bloqueios;
    }

    public Set<AvisoViagem> getAvisos() {
        return avisos;
    }

    public Set<Carteiras> getCarteiras() {
        return carteiras;
    }

    public Set<Parcela> getParcela() {
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

    public Cartao toModel() {
        return new Cartao(id, emitidoEm, titular, bloqueios, avisos, carteiras, parcela, limite, renegociacao, vencimento, idProposta);
    }
}
