package com.zup.proposta.controller;

import com.zup.proposta.model.Biometria;
import com.zup.proposta.model.Cartao;
import com.zup.proposta.repository.BiometriaRepository;
import com.zup.proposta.request.BiometriaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;

@RestController
@RequestMapping(value = "/biometrias")
public class BiometriaController {

    private BiometriaRepository repository;
    @PersistenceContext
    private EntityManager manager;

    public BiometriaController(BiometriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createBiometria(@RequestBody @Valid BiometriaRequest request, UriComponentsBuilder builder) {
        Biometria biometria = request.toModel(manager);
        manager.persist(biometria);
        URI uri = builder.path("/biometrias/{id}").build(biometria.getId());
        return ResponseEntity.created(uri).build();
    }
}
