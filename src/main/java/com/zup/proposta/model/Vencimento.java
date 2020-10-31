package com.zup.proposta.model;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Vencimento {
    String id;
    Integer Dia;
    LocalDateTime dataCriacao;
}
