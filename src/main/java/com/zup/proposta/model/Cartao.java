package com.zup.proposta.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cartao {
    @Id
    private String id;
    private String emitidoEm;
    private String titular;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Bloqueio> bloqueios;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<AvisoViagem> avisos;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Carteiras> carteiras;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Parcela> parcelas;
    private int limite;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Renegociacao> renegociacao;
    @OneToOne(cascade = CascadeType.ALL)
    private Vencimento vencimento;
    private String idProposta;

    @OneToMany(mappedBy = "idCartao")
    Set<Biometria> biometria;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id,
                  String emitidoEm,
                  String titular,
                  Set<Bloqueio> bloqueios,
                  Set<AvisoViagem> avisos,
                  Set<Carteiras> carteiras,
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

    public Set<Carteiras> getCarteiras() {
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
}
