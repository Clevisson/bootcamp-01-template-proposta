package com.zup.proposta.consultaExterna;

import com.zup.proposta.response.RespostaAvaliacaoResponse;
import com.zup.proposta.request.DocumentoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:9999", name = "proposta")
public interface IntegracaoAvaliaProposta {
    @PostMapping("/api/solicitacao")
    public RespostaAvaliacaoResponse avalia(DocumentoRequest request);
}
