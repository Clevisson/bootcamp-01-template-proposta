package com.zup.proposta.request;

import com.zup.proposta.model.Proposal;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class NewProposalRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String address;
    @Positive
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal salary;
    @NotNull
    @Valid
    private String document;

    public NewProposalRequest(@NotEmpty String name,
                              @NotEmpty @Email String email,
                              @NotEmpty String address,
                              @Positive @DecimalMin(value = "0.0", inclusive = false) BigDecimal salary,
                              @NotNull @Valid String document) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.document = document;
    }
    public Proposal toProposal(){
        return new Proposal(name, email, address, salary, document);
    }
}
