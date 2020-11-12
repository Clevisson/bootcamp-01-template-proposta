package com.zup.proposta.response;

import com.zup.proposta.model.*;

import java.util.Set;

public class RespostaCriaCartaoResponse {
    private String id;
    private String emitidoEm;
    private String titular;
    private Set<Bloqueio> bloqueios;
    private Set<AvisoViagem> avisos;
    private Set<Carteira> carteiras;
    private Set<Parcela> parcelas;
    private int limite;
    private Set<Renegociacao> renegociacao;
    private Vencimento vencimento;
    private String idProposta;

    public RespostaCriaCartaoResponse(String id,
                                      String emitidoEm,
                                      String titular,
                                      Set<Bloqueio> bloqueios,
                                      Set<AvisoViagem> avisos,
                                      Set<Carteira> carteiras,
                                      Set<Parcela> parcelas,
                                      int limite,
                                      Set<Renegociacao> renegociacao,
                                      Vencimento vencimento,
                                      String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
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

    public Set<Carteira> getCarteiras() {
        return carteiras;
    }

    public Set<Parcela> getParcelas() {
        return parcelas;
    }

    public int getLimite() {
        return limite;
    }

    public Set<Renegociacao> getRenegociacao() {
        return renegociacao;
    }

    public Vencimento getVencimento() {
        return vencimento;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public Cartao toModel() {
        return new Cartao(id, emitidoEm, titular, bloqueios, avisos, carteiras, parcelas, limite, renegociacao, vencimento, idProposta);
    }
}
