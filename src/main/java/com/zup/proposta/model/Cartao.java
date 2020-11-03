package com.zup.proposta.model;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
public class Cartao {
    @Id
    private String id;
    private String emitidoEm;
    private String titular;
    @Embedded
    private Set<Bloqueio> bloqueios;
    @Embedded
    private Set<AvisoViagem> avisos;
    @Embedded
    private Set<Carteiras> carteiras;
    @Embedded
    private Set<Parcela> parcela;
    private int limite;
    @Embedded
    private Renegociacao renegociacao;
    @Embedded
    private Vencimento vencimento;
    private String idProposta;

    @OneToMany(mappedBy = "cartao")
    List<Biometria> biometria;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id,
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
        this.biometria = biometria;
    }
}
