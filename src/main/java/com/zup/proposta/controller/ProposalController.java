package com.zup.proposta.controller;

import com.zup.proposta.model.Proposal;
import com.zup.proposta.repository.ProposalRepository;
import com.zup.proposta.request.NewProposalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/proposal")
public class ProposalController {
    @Autowired
    private ProposalRepository repository;

    @PostMapping
    public ResponseEntity<Proposal> createProposal(@RequestBody NewProposalRequest request) {
        Proposal proposal = repository.save(request.toProposal());
        return new ResponseEntity<>(proposal, HttpStatus.CREATED);
    }
}
