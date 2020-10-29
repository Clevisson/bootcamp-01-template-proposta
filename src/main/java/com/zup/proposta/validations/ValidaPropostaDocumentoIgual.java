package com.zup.proposta.validations;

import com.zup.proposta.request.PropostaRequest;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ValidaPropostaDocumentoIgual {
    @PersistenceContext
    private EntityManager manager;

    public boolean validaProposta(PropostaRequest request) {
        return manager.createQuery(
                "select d.documento from Proposta d where d.documento = :documento")
                .setParameter("documento", request.getDocumento())
                .getResultList().isEmpty();
    }
}
