package com.zup.proposta.model;

import javax.persistence.*;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idCartao;

    private String fingerprint;

    @Deprecated
    public Biometria() {
    }

    public Biometria(String idCartao, String fingerprint) {
        this.idCartao = idCartao;
        this.fingerprint = fingerprint;
    }

    public void setIdCartao(String idCartao) {
        this.idCartao = idCartao;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public Long getId() {
        return id;
    }
}
