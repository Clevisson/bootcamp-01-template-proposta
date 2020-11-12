package com.zup.proposta.controller;

import com.zup.proposta.consultaExterna.IntegracaoApiCartao;
import com.zup.proposta.enums.StatusBloqueioCartao;
import com.zup.proposta.model.Bloqueio;
import com.zup.proposta.model.Cartao;
import com.zup.proposta.repository.CartaoRepository;
import com.zup.proposta.request.CartaoBloqueadoRequest;
import com.zup.proposta.response.CartaoBloqueadoResponse;
import com.zup.proposta.transacaoGenerica.ExecutaTransacao;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.net.URI;

@RestController
@RequestMapping("/bloqueios")
public class BloqueioCartaoController {
    @Autowired
    private IntegracaoApiCartao bloqueio;

    @Autowired
    private CartaoRepository repository;
    @Autowired
    private ExecutaTransacao executaTransacao;

    @PersistenceContext
    private EntityManager manager;

    @Value("${spring.application.name}")
    private String sistemaResponsavel;

    @PostMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<?> bloqueiaCartao(@PathVariable("idCartao") String idCartao, @RequestHeader("User-Agent") String usuario, UriComponentsBuilder builder) {

        Cartao cartao = manager.find(Cartao.class, idCartao);
        if (cartao == null) {
            return ResponseEntity.notFound().build();
        }
        String ip = ((WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getRemoteAddress();

        Bloqueio cartaoBloqueado = new Bloqueio(ip, usuario);
        executaTransacao.salvaEComita(cartaoBloqueado);
        cartao.getBloqueios().add(cartaoBloqueado);


        try {
            CartaoBloqueadoResponse cartaoBloqueadoResponse = bloqueio.bloqueiaCartao(cartao.getId(), new CartaoBloqueadoRequest(sistemaResponsavel));
            if (cartaoBloqueadoResponse.getResultado().equals("BLOQUEADO")) {
                cartao.setStatusBloqueio(StatusBloqueioCartao.BLOQUEADO);
                executaTransacao.atualizaEComita(cartao);
            }
        } catch (FeignException e) {
            System.out.println(e);
        }


        URI uri = builder.path("/cartoes/{id}").build(cartaoBloqueado.getId());
        return ResponseEntity.created(uri).build();
    }
}
