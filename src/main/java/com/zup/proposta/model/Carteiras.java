package com.zup.proposta.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Carteiras {
    @Id
    private String id;
    @OneToOne
    private CarteiraDigital carteiraDigital;

    @Deprecated
    public Carteiras() {
    }

    public Carteiras(String id, CarteiraDigital carteiraDigital) {
        this.id = id;
        this.carteiraDigital = carteiraDigital;
    }

}
