package com.zup.proposta.controller;

import com.zup.proposta.model.Cartao;
import com.zup.proposta.model.RecuperarSenha;
import feign.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.net.URI;

@RestController
@RequestMapping("/senhas")
public class RecuperarSenhaController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<?> recuperarSenha(@PathVariable("idCartao") String idCartao, @RequestHeader("User-Agent") String usuario, UriComponentsBuilder builder) {
        Cartao cartao = manager.find(Cartao.class, idCartao);
        if (cartao == null) {
            return ResponseEntity.notFound().build();
        }

        String ip = ((WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getRemoteAddress();

        RecuperarSenha recuperarSenha = new RecuperarSenha(ip, usuario);
        manager.persist(recuperarSenha);

        URI uri = builder.path("/cartoes/{id}").build(recuperarSenha.getId());
        return ResponseEntity.created(uri).build();
    }
}
