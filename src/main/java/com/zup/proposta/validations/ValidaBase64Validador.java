package com.zup.proposta.validations;

import com.zup.proposta.request.BiometriaRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ValidaBase64Validador implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return BiometriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        BiometriaRequest request = (BiometriaRequest) target;
        if (!request.isBase64(((BiometriaRequest) target).getFingerPrint())) {
            errors.rejectValue("fingerPrint", null, "Biometria passada não esta no formato Base64");
        }
    }
}
