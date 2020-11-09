package com.zup.proposta.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AvisoViagem {
    @Id
    private String id;
    private String validoAte;
    private String destino;

    @Deprecated
    public AvisoViagem() {
    }

    public AvisoViagem(String id, String validoAte, String destino) {
        this.id = id;
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public String getId() {
        return id;
    }

    public String getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}
