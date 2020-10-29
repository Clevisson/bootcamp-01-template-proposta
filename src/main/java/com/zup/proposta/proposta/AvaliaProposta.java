package com.zup.proposta.proposta;

import com.zup.proposta.ErrorHandler.ValidationErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
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
        String resultadoAnalise = integracoes.avalia( new NovoDocumentoRequest(proposta));
        log.info("passando", resultadoAnalise);
        return RespostaStatusAvaliacao.valueOf(resultadoAnalise).getStatusAvaliacao();
    }
}
