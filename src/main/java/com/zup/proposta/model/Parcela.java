package com.zup.proposta.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Parcela {
    @Column(name = "id_parcela", insertable = false, updatable = false)
    String id;
    @Column(name = "quantidade_parcelas")
    Integer quartidade;
    @Column(name = "valor_parcela")
    Number valor;
}
