package com.zup.proposta.validations;

import com.zup.proposta.request.NewProposalRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ValidatedCPFAndCNPJ implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return NewProposalRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        NewProposalRequest request = (NewProposalRequest) target;
        if (!request.validDocument()) {
            errors.rejectValue("Documento", null, "documento precisa ter um formato de cpf ou cnpj");
        }
    }
}
