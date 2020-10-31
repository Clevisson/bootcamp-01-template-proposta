package com.zup.proposta.repository;


import com.zup.proposta.model.Proposta;
import org.springframework.data.repository.CrudRepository;

public interface PropostaRepository extends CrudRepository<Proposta, String> {
}
