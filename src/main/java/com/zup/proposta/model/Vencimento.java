package com.zup.proposta.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Vencimento {
    @Column(name = "id_vencimento", insertable = false, updatable = false)
    String id;
    @Column(name = "dia_vencimento")
    Integer Dia;
    LocalDateTime dataCriacao;
}
