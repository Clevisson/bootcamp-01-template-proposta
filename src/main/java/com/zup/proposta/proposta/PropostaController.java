package com.zup.proposta.proposta;

import com.zup.proposta.validations.ValidaPropostaDocumentoIgual;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/propostas")
public class PropostaController {

    private ValidaPropostaDocumentoIgual validaPropostaDocumentoIgual;

    private  AvaliaProposta avaliaProposta;

    private ExecutaTransacao executaTransacao;

    public PropostaController(ValidaPropostaDocumentoIgual validaPropostaDocumentoIgual, AvaliaProposta avaliaProposta, ExecutaTransacao executaTransacao) {
        super();
        this.validaPropostaDocumentoIgual = validaPropostaDocumentoIgual;
        this.avaliaProposta = avaliaProposta;
        this.executaTransacao = executaTransacao;
    }

    @PostMapping
    public ResponseEntity<?> createProposal(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder builder) {
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
}
