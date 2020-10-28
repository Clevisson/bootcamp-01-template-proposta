package com.zup.proposta.repository;

import com.zup.proposta.model.Proposal;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProposalRepository extends CrudRepository<Proposal, Long> {
    Optional<Proposal> findByDocument(String document);
}
