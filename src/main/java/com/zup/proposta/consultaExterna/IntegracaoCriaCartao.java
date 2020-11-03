package com.zup.proposta.consultaExterna;

import com.zup.proposta.response.RespostaCriaCartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(url = "http://localhost:8888", name = "CriaCartao")
public interface IntegracaoCriaCartao {

    @GetMapping("/api/cartoes")
    @ResponseBody
    ResponseEntity<RespostaCriaCartaoResponse> consultaCartaoCriado(@RequestParam String idProposta);
}
