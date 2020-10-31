package com.zup.proposta.model;

import javax.persistence.Embeddable;

@Embeddable
public class Parcela {
    String id;
    Integer quartidade;
    Number valor;
}
