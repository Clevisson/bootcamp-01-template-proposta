package com.zup.proposta.controller;

import com.zup.proposta.consultaExterna.IntegracaoApiCartao;
import com.zup.proposta.model.AvisoViagem;
import com.zup.proposta.model.Cartao;
import com.zup.proposta.request.AvisoViagemRequest;
import com.zup.proposta.response.AvisoViagemResponse;
import com.zup.proposta.transacaoGenerica.ExecutaTransacao;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("avisos")
public class AvisoViagemController {
    @Autowired
    private ExecutaTransacao executaTransacao;
    @Autowired
    private IntegracaoApiCartao aviso;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<?> criaAvisoViagem(@PathVariable("idCartao") String idCartao, @Valid @RequestBody AvisoViagemRequest request, @RequestHeader("User-Agent") String usuario, UriComponentsBuilder builder) {
        Cartao cartao = manager.find(Cartao.class, idCartao);
        if (cartao == null) {
            return ResponseEntity.notFound().build();
        }
        String ip = ((WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getRemoteAddress();

        AvisoViagem avisoViagem = new AvisoViagem(request.getDestino(), request.getValidoAte(), ip, usuario);
        executaTransacao.salvaEComita(avisoViagem);

        try {
            AvisoViagemResponse avisoViagemResponse = aviso.AvisoViagem(cartao.getId(), new AvisoViagemRequest(request.getDestino(), request.getValidoAte()));
            if (avisoViagemResponse.getResultado().equals("CRIADO")) {
                cartao.getAvisos().add(avisoViagem);
                executaTransacao.atualizaEComita(cartao);
            }
        } catch (FeignException e) {
            System.out.println(e);
        }

        URI uri = builder.path("/avisos/{id}").build(avisoViagem.getId());
        return ResponseEntity.created(uri).build();
    }
}
