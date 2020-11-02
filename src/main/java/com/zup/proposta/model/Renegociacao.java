package com.zup.proposta.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Renegociacao {
    @Column(name = "id_renegociacao",insertable = false, updatable = false)
    String id;
    @Column(name = "quantidade_renegociacao")
    Integer quartidade;
    @Column(name = "valor_renegociacao")
    Number valor;
    @Column(name = "data_criacao_renegociacao")
    LocalDateTime dataCriacao;
}
