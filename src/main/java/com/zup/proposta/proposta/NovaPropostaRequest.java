package com.zup.proposta.proposta;

import com.zup.proposta.validations.ValidaCPF_E_CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NovaPropostaRequest {
    @NotBlank
    private final String nome;
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    private final String endereco;
    @Positive
    @NotNull
    private final BigDecimal salario;
    @NotBlank
    @ValidaCPF_E_CNPJ
    private final String documento;

    public NovaPropostaRequest(@NotBlank String nome,
                               @NotBlank @Email String email,
                               @NotBlank String endereco,
                               @Positive BigDecimal salario,
                               String documento) {
        super();
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.salario = salario;
        this.documento = documento;
    }

    public Proposta toProposal() {
        return new Proposta(nome, email, endereco, salario, documento);
    }

    public String getDocumento() {
        return documento;
    }
}
