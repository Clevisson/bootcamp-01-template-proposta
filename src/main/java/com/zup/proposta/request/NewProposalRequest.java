package com.zup.proposta.request;

import com.zup.proposta.model.Proposal;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

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

    public boolean validDocument() {
        Assert.hasLength(document, "Não é possivel validar um documento vazio");
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);
        return cnpjValidator.isValid(document, null) || cnpjValidator.isValid(document, null);
    }
}
