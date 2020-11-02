package com.zup.proposta.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class CarteiraDigital {
    @Column(name = "id_CarteiraDigital", insertable = false, updatable = false)
    String id;
    @Column(name = "email_carteira_digital")
    String email;
    @Column(name = "associado_em_carteira_digital")
    String associadoEm;
    @Column(name = "emissor_carteira_digital")
    String emissor;
}
