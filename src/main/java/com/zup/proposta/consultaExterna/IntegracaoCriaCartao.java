package com.zup.proposta.consultaExterna;

import com.zup.proposta.request.AvisoViagemRequest;
import com.zup.proposta.request.CartaoBloqueadoRequest;
import com.zup.proposta.response.AvisoViagemResponse;
import com.zup.proposta.response.CartaoBloqueadoResponse;
import com.zup.proposta.response.RespostaCriaCartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "http://localhost:8888", name = "CriaCartao")
public interface IntegracaoCriaCartao {

    @GetMapping("/api/cartoes")
    @ResponseBody
    ResponseEntity<RespostaCriaCartaoResponse> consultaCartaoCriado(@RequestParam String idProposta);

    @PostMapping("/api/cartoes/{idCartao}/bloqueios")
    CartaoBloqueadoResponse bloqueiaCartao(@PathVariable String idCartao, @RequestBody CartaoBloqueadoRequest request);

    @PostMapping("/api/cartoes/{idCartao}/avisos")
    AvisoViagemResponse AvisoViagem(@PathVariable String idCartao, @RequestBody AvisoViagemRequest request);
}
