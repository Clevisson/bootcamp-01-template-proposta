package com.zup.proposta.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Bloqueio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private UUID id;

    private LocalDateTime bloqueadoEm = LocalDateTime.now();

    private Boolean ativo = true;

    private String ipClienteSolicitante;

    private String userAgente;

    @Deprecated
    public Bloqueio() {
    }

    public Bloqueio(String ipClienteSolicitante, String userAgente) {
        this.ipClienteSolicitante = ipClienteSolicitante;
        this.userAgente = userAgente;
    }

    public UUID getId() {
        return id;
    }
}
