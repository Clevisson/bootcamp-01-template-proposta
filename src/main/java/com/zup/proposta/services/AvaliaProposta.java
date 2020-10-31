package com.zup.proposta.services;

import com.zup.proposta.response.RespostaAvaliacaoResponse;
import com.zup.proposta.consultaExterna.Integracoes;
import com.zup.proposta.consultaExterna.StatusAvaliacaoProposta;
import com.zup.proposta.errorHandler.ValidationErrorHandler;
import com.zup.proposta.model.Proposta;
import com.zup.proposta.request.DocumentoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class AvaliaProposta {
    @Autowired
    private Integracoes integracoes;
    @Autowired
    private CriaCartao solicitaCriarCartao;

    public StatusAvaliacaoProposta executa(@NotNull @Validated Proposta proposta) {
        RespostaAvaliacaoResponse resultadoAnalise = integracoes.avalia(new DocumentoRequest(proposta));
        if (resultadoAnalise.getResultadoSolicitacao().equals("COM_RESTRICAO")) {
            solicitaCriarCartao.executa(proposta);
            return StatusAvaliacaoProposta.elegivel;
        }
        return StatusAvaliacaoProposta.nao_elegivel;
    }
}


