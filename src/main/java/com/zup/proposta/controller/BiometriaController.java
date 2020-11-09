package com.zup.proposta.controller;

import com.zup.proposta.model.Biometria;
import com.zup.proposta.repository.CartaoRepository;
import com.zup.proposta.request.BiometriaRequest;
import com.zup.proposta.validations.ValidaBase64Validador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/biometrias")
public class BiometriaController {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private CartaoRepository repository;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new ValidaBase64Validador());
    }

    @PostMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<?> createBiometria(@RequestBody @Valid BiometriaRequest request, @PathVariable("idCartao") String idCartao, UriComponentsBuilder builder) {

        if (repository.findById(idCartao).isPresent()) {
            Biometria biometria = request.toModel(idCartao, request.getFingerPrint());
            manager.persist(biometria);

            URI uri = builder.path("/biometrias/{id}").build(biometria.getId());
            return ResponseEntity.created(uri).build();

        } else return ResponseEntity.notFound().build();
    }
}
