package com.zup.proposta.proposta;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ExecutaTransacao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public <T> T salvaEComita(T objeto) {
        manager.persist(objeto);
        return objeto;
    }

    @Transactional
    public <T> T atualizaEComita(T objeto) {
        return manager.merge(objeto);
    }
}

