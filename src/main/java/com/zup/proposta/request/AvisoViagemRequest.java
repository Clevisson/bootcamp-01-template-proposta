package com.zup.proposta.request;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class AvisoViagemRequest {
    @NotBlank
    private String destino;
    @NotNull
    @Future
    private Date validoAte;

    @Deprecated
    public AvisoViagemRequest() {
    }

    public AvisoViagemRequest(@NotBlank String destino, @NotNull @Future Date validoAte) {
        this.destino = destino;
        this.validoAte = validoAte;
    }

    public String getDestino() {
        return destino;
    }

    public Date getValidoAte() {
        return validoAte;
    }
}
