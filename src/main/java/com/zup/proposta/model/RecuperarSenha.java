package com.zup.proposta.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class RecuperarSenha {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private UUID id;

    private LocalDateTime instanteSolicitacao = LocalDateTime.now();

    private String ipClienteSolicitante;

    private String userAgente;

    @Deprecated
    public RecuperarSenha() {
    }

    public RecuperarSenha(String ipClienteSolicitante, String userAgente) {
        this.ipClienteSolicitante = ipClienteSolicitante;
        this.userAgente = userAgente;
    }

    public UUID getId() {
        return id;
    }
}
