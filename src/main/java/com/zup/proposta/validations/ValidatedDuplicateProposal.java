package com.zup.proposta.validations;

import com.zup.proposta.repository.ProposalRepository;
import com.zup.proposta.request.NewProposalRequest;
import org.springframework.stereotype.Component;

@Component
public class ValidatedDuplicateProposal {
    //1
    private final ProposalRepository repository;


    public ValidatedDuplicateProposal(ProposalRepository repository) {
        this.repository = repository;
    }

    //2
    public boolean validProposal(NewProposalRequest request) {
        return repository.findByDocument(request.getDocument()).isEmpty();
    }
}
