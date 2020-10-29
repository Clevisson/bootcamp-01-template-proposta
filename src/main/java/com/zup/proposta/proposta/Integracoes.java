package com.zup.proposta.proposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "http://localhost:9999/", name = "proposta")
public interface Integracoes {
    @PostMapping("/api/solicitacao")
    public String avalia(NovoDocumentoRequest request);
}
