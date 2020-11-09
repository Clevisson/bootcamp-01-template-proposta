package com.zup.proposta.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarteiraDigital {
    @Id
    private String id;
    private String email;
    private String associadoEm;
    private String emissor;
}
