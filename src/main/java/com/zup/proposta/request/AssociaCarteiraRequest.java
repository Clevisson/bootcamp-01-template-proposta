package com.zup.proposta.request;

import com.zup.proposta.enums.EmissorCarteiras;
import com.zup.proposta.model.Carteira;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;

public class AssociaCarteiraRequest {
    @NotBlank
    private String email;
    @Enumerated(EnumType.STRING)
    private EmissorCarteiras carteira;

    public AssociaCarteiraRequest(String email, EmissorCarteiras carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public String getEmail() {
        return email;
    }

    public EmissorCarteiras getCarteira() {
        return carteira;
    }

}
