package com.zup.proposta.model;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Renegociacao {
    String id;
    Integer quartidade;
    Number valor;
    LocalDateTime dataCriacao;
}
