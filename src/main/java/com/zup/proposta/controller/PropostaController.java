package com.zup.proposta.controller;

import com.zup.proposta.consultaExterna.StatusAvaliacaoProposta;
import com.zup.proposta.model.Proposta;
import com.zup.proposta.repository.PropostaRepository;
import com.zup.proposta.request.PropostaRequest;
import com.zup.proposta.services.AvaliaProposta;
import com.zup.proposta.transacaoGenerica.ExecutaTransacao;
import com.zup.proposta.validations.ValidaPropostaDocumentoIgual;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/propostas")
public class PropostaController {

    private ValidaPropostaDocumentoIgual validaPropostaDocumentoIgual;

    private AvaliaProposta avaliaProposta;

    private ExecutaTransacao executaTransacao;

    private PropostaRepository repository;


    public PropostaController(ValidaPropostaDocumentoIgual validaPropostaDocumentoIgual, AvaliaProposta avaliaProposta, ExecutaTransacao executaTransacao, PropostaRepository repository) {
        super();
        this.validaPropostaDocumentoIgual = validaPropostaDocumentoIgual;
        this.avaliaProposta = avaliaProposta;
        this.executaTransacao = executaTransacao;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> createProposal(@RequestBody @Valid PropostaRequest request, UriComponentsBuilder builder) {
        if (!validaPropostaDocumentoIgual.validaProposta(request)) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        Proposta proposta = request.toProposal();
        executaTransacao.salvaEComita(proposta);

        StatusAvaliacaoProposta avaliacao = avaliaProposta.executa(proposta);
        proposta.atualizaStatus(avaliacao);
        executaTransacao.atualizaEComita(proposta);

        URI uri = builder.path("/proposal/{id}").build(proposta.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> listaPropostaporId(@PathVariable("id") UUID id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}
