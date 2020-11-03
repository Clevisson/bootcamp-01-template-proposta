package com.zup.proposta.repository;

import com.zup.proposta.model.Biometria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BiometriaRepository extends CrudRepository<Biometria, Long> {
    Optional<Biometria> findById(String idCartao);
}
