package com.zup.proposta.model;

import com.zup.proposta.enums.StatusBloqueioCartao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cartao {
    @Id
    private String id;

    private String emitidoEm;

    private String titular;

    @Enumerated(EnumType.STRING)
    private StatusBloqueioCartao statusBloqueio;

    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "bloqueios_id")
    private Set<Bloqueio> bloqueios = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "avisos_id")
    private Set<AvisoViagem> avisos = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "carteiras_id")
    private Set<Carteiras> carteiras = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parcelas_id")
    private Set<Parcela> parcelas = new HashSet<>();

    private int limite;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "renegociacao_id")
    private Set<Renegociacao> renegociacao = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Vencimento vencimento;

    private String idProposta;

    @OneToMany(mappedBy = "idCartao")
    Set<Biometria> biometria = new HashSet<>();

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
        this.statusBloqueio = StatusBloqueioCartao.DESBLOQUEADO;
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

    public void setStatusBloqueio(StatusBloqueioCartao statusBloqueio) {
        this.statusBloqueio = statusBloqueio;
    }

    public StatusBloqueioCartao getStatusBloqueio() {
        return statusBloqueio;
    }
}
