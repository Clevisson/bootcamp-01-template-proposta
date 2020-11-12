package com.zup.proposta.model;

import com.zup.proposta.enums.EmissorCarteiras;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Carteira {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private UUID id;

    private String email;

    private LocalDateTime associadoEm = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private EmissorCarteiras emissor;

    @Deprecated
    public Carteira() {
    }

    public Carteira(String email, EmissorCarteiras emissor) {
        this.email = email;
        this.emissor = emissor;
    }


    public boolean verificaCarteiraIgual(EmissorCarteiras emissorCarteiras) {
        return this.emissor.equals(emissorCarteiras);
    }

    public UUID getId() {
        return id;
    }
}
