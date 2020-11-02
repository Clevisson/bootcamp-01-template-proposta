package com.zup.proposta.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AvisoViagem {
    @Column(name = "validadade_aviso_viagem")
    String validoAte;
    @Column(name = "destino_aviso_viagem")
    String destino;
}
