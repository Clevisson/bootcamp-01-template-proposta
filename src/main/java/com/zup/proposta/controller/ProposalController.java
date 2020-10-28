package com.zup.proposta.controller;

import com.zup.proposta.model.Proposal;
import com.zup.proposta.repository.ProposalRepository;
import com.zup.proposta.request.NewProposalRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ProposalRepository repository;

    @PostMapping
    @Transactional
    //1
    public ResponseEntity<Proposal> createProposal(@RequestBody @Valid NewProposalRequest request, UriComponentsBuilder builder) {
        //1
        Proposal proposal = repository.save(request.toProposal());
        URI uri = builder.path("/proposal/{id}").build(proposal.getId());
        return ResponseEntity.created(uri).build();
    }
}
