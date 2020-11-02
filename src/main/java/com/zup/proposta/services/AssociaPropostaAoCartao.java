package com.zup.proposta.services;

import com.zup.proposta.consultaExterna.IntegracaoCriaCartao;
import com.zup.proposta.consultaExterna.StatusAvaliacaoProposta;
import com.zup.proposta.model.Proposta;
import com.zup.proposta.response.RespostaCriaCartaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Component
@EnableScheduling
public class AssociaPropostaAoCartao {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private IntegracaoCriaCartao integracaoCriaCartao;

    @Scheduled(fixedRate = 3000)
    public void Associa() {
        List<Proposta> propostasLegiveis = manager
                .createQuery("SELECT p FROM Proposta p WHERE statusAvaliacao = :statusAvaliacao AND cartao_id =null", Proposta.class)
                .setParameter("statusAvaliacao", StatusAvaliacaoProposta.elegivel)
                .getResultList();

        for (Proposta p : propostasLegiveis) {
            ResponseEntity<RespostaCriaCartaoResponse> resposta = integracaoCriaCartao.consultaCartaoCriado(p.getId().toString());
            if (resposta.getStatusCode() == HttpStatus.OK) {
                p.setCartao(Objects.requireNonNull(resposta.getBody()).toModel());
            }
            manager.merge(p);
        }
    }
}
