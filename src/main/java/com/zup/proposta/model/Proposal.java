package com.zup.proposta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private String Document;

    @Deprecated
    public Proposal() {
    }

    public Proposal(@NotEmpty String name,
                    @NotEmpty @Email String email,
                    @NotEmpty String address,
                    @Positive @DecimalMin(value = "0.0", inclusive = false) BigDecimal salary,
                    @NotNull @Valid String document) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.salary = salary;
        Document = document;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", Document='" + Document + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getDocument() {
        return Document;
    }
}
