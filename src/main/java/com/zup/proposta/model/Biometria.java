package com.zup.proposta.model;

import com.zup.proposta.validations.ValidaBase64;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cartao cartao;

    @ValidaBase64
    private String fingerprint;

    @Deprecated
    public Biometria() {
    }

    public Biometria(Cartao cartao, String fingerprint) {
        this.cartao = cartao;
        this.fingerprint = fingerprint;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public Long getId() {
        return id;
    }
}
