package com.zup.proposta.model;

import com.zup.proposta.validations.ValidCPFAndCNPJ;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @Deprecated
    public Proposal() {
    }

    public Proposal(@NotBlank String name,
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

    public Long getId() {
        return id;
    }
}
