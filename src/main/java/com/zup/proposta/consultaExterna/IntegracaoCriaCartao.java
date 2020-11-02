package com.zup.proposta.consultaExterna;

import com.zup.proposta.request.CartaoRequest;
import com.zup.proposta.response.RespostaCriaCartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:8888/", name = "CriaCartao")

public interface IntegracaoCriaCartao {
    @Async
    @PostMapping("/api/cartoes")
    RespostaCriaCartaoResponse criaCartao(@RequestBody CartaoRequest request);

    @GetMapping("api/cartoes")
    ResponseEntity<RespostaCriaCartaoResponse> consultaCartaoCriado(@RequestParam String idProposta);
}
