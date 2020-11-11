package com.zup.proposta.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
public class AvisoViagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private UUID id;
    @NotNull
    private Date validoAte;
    @NotBlank
    private String destino;
    private LocalDateTime instanteAvisoViagem = LocalDateTime.now();
    @NotBlank
    private String ipClienteSolicitante;
    @NotBlank
    private String userAgente;

    @Deprecated
    public AvisoViagem() {
    }
/*
    public AvisoViagem(String validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

 */

    public AvisoViagem(String destino, Date validoAte, String ipClienteSolicitante, String userAgente) {
        this.ipClienteSolicitante = ipClienteSolicitante;
        this.userAgente = userAgente;
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public UUID getId() {
        return id;
    }

    public Date getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}
