package com.zup.proposta.services;

import com.zup.proposta.consultaExterna.IntegracaoApiCartao;
import com.zup.proposta.enums.StatusAvaliacaoProposta;
import com.zup.proposta.model.Cartao;
import com.zup.proposta.model.Proposta;
import com.zup.proposta.response.RespostaCriaCartaoResponse;
import com.zup.proposta.transacaoGenerica.ExecutaTransacao;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@EnableScheduling
public class AssociaPropostaAoCartao {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private IntegracaoApiCartao integracaoApiCartao;

    @Autowired
    private ExecutaTransacao executaTransacao;

    @Scheduled(fixedRate = 1000)
    public void Associa() {
        List<Proposta> propostasLegiveis = manager
                .createQuery("SELECT p FROM Proposta p WHERE statusAvaliacao = :statusAvaliacao AND cartao_id =null", Proposta.class)
                .setParameter("statusAvaliacao", StatusAvaliacaoProposta.elegivel)
                .getResultList();

        for (Proposta p : propostasLegiveis) {
            try {
                ResponseEntity<RespostaCriaCartaoResponse> resposta = integracaoApiCartao.consultaCartaoCriado(p.getId().toString());
                System.out.println(resposta.toString());
                if (resposta.getStatusCode() == HttpStatus.OK) {
                    Cartao cartao = new Cartao(resposta.getBody().getId(),
                            resposta.getBody().getEmitidoEm(),
                            resposta.getBody().getTitular(),
                            resposta.getBody().getBloqueios(),
                            resposta.getBody().getAvisos(),
                            resposta.getBody().getCarteiras(),
                            resposta.getBody().getParcelas(),
                            resposta.getBody().getLimite(),
                            resposta.getBody().getRenegociacao(),
                            resposta.getBody().getVencimento(),
                            resposta.getBody().getIdProposta());
                    p.setCartao(resposta.getBody().toModel());
                    executaTransacao.salvaEComita(cartao);
                }
                executaTransacao.atualizaEComita(p);
            } catch (FeignException e) {
                System.out.println(e);
            }
        }
    }
}
