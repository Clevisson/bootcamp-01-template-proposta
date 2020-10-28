package com.zup.proposta.controller;

import com.zup.proposta.model.Proposal;
import com.zup.proposta.repository.ProposalRepository;
import com.zup.proposta.request.NewProposalRequest;
import com.zup.proposta.validations.ValidatedDuplicateProposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/proposal")
public class ProposalController {
    //1
    private final ProposalRepository repository;
    //1
    private final ValidatedDuplicateProposal validatedDuplicateProposal;

    public ProposalController(ProposalRepository repository, ValidatedDuplicateProposal validatedDuplicateProposal) {
        this.repository = repository;
        this.validatedDuplicateProposal = validatedDuplicateProposal;
    }

    @PostMapping
    @Transactional
    //1
    public ResponseEntity<Proposal> createProposal(@RequestBody @Valid NewProposalRequest request, UriComponentsBuilder builder) {
        //1
        if (validatedDuplicateProposal.validProposal(request)) {
            //1
            Proposal proposal = repository.save(request.toProposal());
            URI uri = builder.path("/proposal/{id}").build(proposal.getId());
            return ResponseEntity.created(uri).build();
            //1
        } else
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
}
