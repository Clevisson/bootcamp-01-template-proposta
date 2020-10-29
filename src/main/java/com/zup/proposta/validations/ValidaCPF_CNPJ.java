package com.zup.proposta.validations;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ValidaCPF_CNPJ implements ConstraintValidator<ValidaCPF_E_CNPJ, CharSequence> {

    @Override
    public boolean isValid(CharSequence value,
                           ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        CNPJValidator cnpjValidator = new CNPJValidator();
        CPFValidator cpfValidator = new CPFValidator();

        cnpjValidator.initialize(null);
        cpfValidator.initialize(null);

        return cnpjValidator.isValid(value, context)
                || cpfValidator.isValid(value, context);
    }
}
