package com.zup.proposta.controller;

import com.zup.proposta.model.Proposal;
import com.zup.proposta.repository.ProposalRepository;
import com.zup.proposta.request.NewProposalRequest;
import com.zup.proposta.validations.ValidatedCPFAndCNPJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/proposal")
public class ProposalController {
    @Autowired
    private ProposalRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Proposal> createProposal(@RequestBody @Valid NewProposalRequest request, UriComponentsBuilder builder) {
        Proposal proposal = repository.save(request.toProposal());
        URI uri = builder.path("/proposal/{id}").build(proposal.getId());
        return ResponseEntity.created(uri).build();
    }
}
