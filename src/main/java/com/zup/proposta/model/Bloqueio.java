package com.zup.proposta.model;

import javax.persistence.Embeddable;

@Embeddable
public class Bloqueio {
    String id;
    String bloqueadoEm;
    String sistemaResponsavel;
    Boolean ativo;
}
