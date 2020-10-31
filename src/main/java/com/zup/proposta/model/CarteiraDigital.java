package com.zup.proposta.model;

import javax.persistence.Embeddable;


@Embeddable
public class CarteiraDigital {
    String id;
    String email;
    String associadoEm;
    String emissor;
}
