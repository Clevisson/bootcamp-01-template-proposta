package com.zup.proposta.proposta;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.zup.proposta.validations.ValidaCPF_E_CNPJ;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class NovoDocumentoRequest {
    @ValidaCPF_E_CNPJ
    private String documento;

    @Deprecated
    public NovoDocumentoRequest() {

    }
    public NovoDocumentoRequest(Proposta proposta) {
        this.documento = proposta.getDocumento();
    }
}
