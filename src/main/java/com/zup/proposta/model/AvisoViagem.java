package com.zup.proposta.model;

import javax.persistence.Embeddable;

@Embeddable
public class AvisoViagem {
    String validoAte;
    String destino;
}
