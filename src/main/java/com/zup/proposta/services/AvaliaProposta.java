package com.zup.proposta.services;

import com.zup.proposta.consultaExterna.IntegracaoAvaliaProposta;
import com.zup.proposta.enums.StatusAvaliacaoProposta;
import com.zup.proposta.model.Proposta;
import com.zup.proposta.request.DocumentoRequest;
import com.zup.proposta.response.RespostaAvaliacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class AvaliaProposta {
    @Autowired
    private IntegracaoAvaliaProposta integracaoAvaliaProposta;

    public StatusAvaliacaoProposta executa(@NotNull @Validated Proposta proposta) {
        try {
            RespostaAvaliacaoResponse resultadoAnalise = integracaoAvaliaProposta.avalia(new DocumentoRequest(proposta));
            System.out.println(resultadoAnalise);
            if (!resultadoAnalise.getResultadoSolicitacao().equals("COM_RESTRICAO")) {
                return StatusAvaliacaoProposta.elegivel;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return StatusAvaliacaoProposta.nao_elegivel;
    }
}

