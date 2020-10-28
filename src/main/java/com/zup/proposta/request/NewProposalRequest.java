package com.zup.proposta.request;

import com.zup.proposta.model.Proposal;
import com.zup.proposta.validations.ValidCPFAndCNPJ;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class NewProposalRequest {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String address;
    @Positive
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal salary;
    @NotNull
    @ValidCPFAndCNPJ
    private String document;

    public NewProposalRequest(@NotBlank String name,
                              @NotBlank @Email String email,
                              @NotBlank String address,
                              @Positive @DecimalMin(value = "0.0", inclusive = false) BigDecimal salary,
                              @NotNull String document) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.document = document;
    }

    //1
    public Proposal toProposal() {
        return new Proposal(name, email, address, salary, document);
    }
}
