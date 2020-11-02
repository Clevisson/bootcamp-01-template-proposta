package com.zup.proposta.repository;


import com.zup.proposta.model.Proposta;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PropostaRepository extends CrudRepository<Proposta, UUID> {
}
