package com.zup.proposta.proposta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class IntegracoesController {
    private AtomicInteger contDocuments = new AtomicInteger();

    @PostMapping(value = "/avalia")
    public String avaliaDocumento(@RequestBody NovoDocumentoRequest request) {
        int cont = contDocuments.getAndIncrement();
        if (cont % 2 != 0) {
            return "COM_RESTRICAO";
        }
        return "SEM_RESTRICAO";
    }
}
