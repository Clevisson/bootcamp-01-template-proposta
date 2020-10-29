package com.zup.proposta.model;

import com.zup.proposta.consultaExterna.StatusAvaliacaoProposta;
import com.zup.proposta.validations.ValidaCPF_E_CNPJ;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String endereco;
    @Positive
    private BigDecimal salario;
    @NotBlank
    @ValidaCPF_E_CNPJ
    private String documento;

   @NotNull
   @Enumerated(EnumType.STRING)
   private StatusAvaliacaoProposta statusAvaliacao;

    public Proposta(@NotBlank String nome,
                    @NotBlank @Email String email,
                    @NotBlank String endereco,
                    @Positive BigDecimal salario,
                    String documento
                   ) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.salario = salario;
        this.documento = documento;
        this.statusAvaliacao = StatusAvaliacaoProposta.nao_elegivel;
    }



    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Proposta other = (Proposta) obj;
        if (documento == null) {
            if (other.documento != null)
                return false;
        } else if (!documento.equals(other.documento))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((documento == null) ? 0 : documento.hashCode());
        return result;
    }
    public void atualizaStatus(StatusAvaliacaoProposta statusAvaliacao) {
        Assert.isTrue(this.statusAvaliacao.equals(StatusAvaliacaoProposta.nao_elegivel),
                "Uma vez que sua proposta é elegivel, não pode mais trocar");
        this.statusAvaliacao = statusAvaliacao;
    }
}
