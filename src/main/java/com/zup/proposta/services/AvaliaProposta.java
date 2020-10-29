package com.zup.proposta.services;

import com.zup.proposta.consultaExterna.Integracoes;
import com.zup.proposta.consultaExterna.RespostaStatusAvaliacao;
import com.zup.proposta.consultaExterna.StatusAvaliacaoProposta;
import com.zup.proposta.errorHandler.ValidationErrorHandler;
import com.zup.proposta.model.Proposta;
import com.zup.proposta.request.DocumentoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class AvaliaProposta {
    private static final Logger log = LoggerFactory
            .getLogger(ValidationErrorHandler.class);
    @Autowired
    private Integracoes integracoes;

    public StatusAvaliacaoProposta executa(@NotNull @Validated Proposta proposta) {
        String resultadoAnalise = integracoes.avalia(new DocumentoRequest(proposta));
        log.info("passando", resultadoAnalise);
        return RespostaStatusAvaliacao.valueOf(resultadoAnalise).getStatusAvaliacao();
    }
}
