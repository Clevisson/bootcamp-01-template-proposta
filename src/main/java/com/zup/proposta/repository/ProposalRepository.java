package com.zup.proposta.repository;

import com.zup.proposta.model.Proposal;
import org.springframework.data.repository.CrudRepository;

public interface ProposalRepository extends CrudRepository<Proposal, Long> {
}
