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

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/proposal")
public class ProposalController {
    @Autowired
    private ProposalRepository repository;
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new ValidatedCPFAndCNPJ());
    }

    @PostMapping
    public ResponseEntity<Proposal> createProposal(@RequestBody @Valid NewProposalRequest request) {
        Proposal proposal = repository.save(request.toProposal());
        return new ResponseEntity<>(proposal, HttpStatus.CREATED);
    }
}
