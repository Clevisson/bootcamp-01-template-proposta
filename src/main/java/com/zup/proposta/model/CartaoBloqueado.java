package com.zup.proposta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class CartaoBloqueado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private LocalDateTime InstanteBloqueio = LocalDateTime.now();

    private String ipClienteSolicitante;

    private String UserAgente;

    @Deprecated
    public CartaoBloqueado() {
    }

    public CartaoBloqueado(String userAgente,
                           String ipClienteSolicitante
    ) {
        this.ipClienteSolicitante = ipClienteSolicitante;
        UserAgente = userAgente;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getInstanteBloqueio() {
        return InstanteBloqueio;
    }
}
