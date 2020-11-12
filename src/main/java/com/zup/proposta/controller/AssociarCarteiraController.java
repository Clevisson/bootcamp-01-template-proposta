package com.zup.proposta.controller;

import com.zup.proposta.consultaExterna.IntegracaoApiCartao;
import com.zup.proposta.model.Cartao;
import com.zup.proposta.model.Carteira;
import com.zup.proposta.request.AssociaCarteiraRequest;
import com.zup.proposta.transacaoGenerica.ExecutaTransacao;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/carteiras")
public class AssociarCarteiraController {

    @Autowired
    private ExecutaTransacao executaTransacao;

    @Autowired
    private IntegracaoApiCartao associa;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<?> associarCarteira(@PathVariable("idCartao") String idCartao, @Valid @RequestBody AssociaCarteiraRequest request, UriComponentsBuilder builder) {

        Cartao cartao = manager.find(Cartao.class, idCartao);
        if (cartao == null) {
            return ResponseEntity.notFound().build();
        }

        if (cartao.VerificaEmissorCarteiraIgual(request.getCarteira())) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Carteira carteira = new Carteira(request.getEmail(), request.getCarteira());

        try {
            ResponseEntity<?> associaCarteira = associa.AssociaCarteira(idCartao, request);
            if (associaCarteira.getStatusCode() == HttpStatus.OK) {
                cartao.getCarteiras().add(carteira);
                executaTransacao.salvaEComita(carteira);
                executaTransacao.atualizaEComita(cartao);
            }
        } catch (FeignException e) {
            System.out.println(e);
            return ResponseEntity.unprocessableEntity().body("Erro feign");
        }

        URI uri = builder.path("/carteiras/{id}").build(carteira.getId());
        return ResponseEntity.created(uri).build();
    }
}
