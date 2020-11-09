package com.zup.proposta.controller;

import com.zup.proposta.model.CartaoBloqueado;
import com.zup.proposta.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CartaoRepository repository;
    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<?> bloqueiaCartao(@PathVariable("idCartao") String idCartao, @RequestHeader("User-Agent") String usuario, UriComponentsBuilder builder) {
        if (repository.findById(idCartao).isPresent()) {

            String ip = ((WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getRemoteAddress();

            CartaoBloqueado cartaoBloqueado = new CartaoBloqueado(usuario, ip);
            manager.persist(cartaoBloqueado);

            URI uri = builder.path("/cartoes/{id}").build(cartaoBloqueado.getId());
            return ResponseEntity.created(uri).build();

        } else return ResponseEntity.notFound().build();
    }
}