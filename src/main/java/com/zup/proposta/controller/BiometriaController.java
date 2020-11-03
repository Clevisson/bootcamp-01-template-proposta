package com.zup.proposta.controller;

import com.zup.proposta.model.Biometria;
import com.zup.proposta.repository.BiometriaRepository;
import com.zup.proposta.request.BiometriaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/biometrias")
public class BiometriaController {

    private BiometriaRepository repository;

    public BiometriaController(BiometriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> createBiometria(@RequestBody @Valid BiometriaRequest request, @PathVariable("cartao_id") String idCartao, UriComponentsBuilder builder) {
        return repository.findById(idCartao)
                .map(record -> {
                    record.setFingerprint(request.getFingerPrint());
                    Biometria biometria = repository.save(record);
                    URI uri = builder.path("/proposal/{id}").build(biometria.getId());
                    return ResponseEntity.created(uri).build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
