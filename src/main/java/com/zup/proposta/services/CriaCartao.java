package com.zup.proposta.services;

import com.zup.proposta.consultaExterna.IntegracaoCriaCartao;
import com.zup.proposta.model.Proposta;
import com.zup.proposta.request.CartaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@EnableAsync
@Component
public class CriaCartao {

    @Autowired
    private IntegracaoCriaCartao integracao;

    public void executa(@NotNull Proposta request) {
        integracao.criaCartao(new CartaoRequest(request));
    }

}
