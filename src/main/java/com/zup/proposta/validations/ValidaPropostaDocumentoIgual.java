package com.zup.proposta.validations;

import com.zup.proposta.proposta.NovaPropostaRequest;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ValidaPropostaDocumentoIgual {
    @PersistenceContext
    private EntityManager manager;

    public boolean validaProposta(NovaPropostaRequest request) {
        return manager.createQuery(
                "select d.documento from Proposta d where d.documento = :documento")
                .setParameter("documento", request.getDocumento())
                .getResultList().isEmpty();
    }
}
