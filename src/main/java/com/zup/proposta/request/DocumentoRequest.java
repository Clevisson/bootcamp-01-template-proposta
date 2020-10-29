package com.zup.proposta.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.zup.proposta.model.Proposta;
import com.zup.proposta.validations.ValidaCPF_E_CNPJ;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DocumentoRequest {
    @ValidaCPF_E_CNPJ
    private String documento;

    @Deprecated
    public DocumentoRequest() {

    }
    public DocumentoRequest(Proposta proposta) {
        this.documento = proposta.getDocumento();
    }
}
