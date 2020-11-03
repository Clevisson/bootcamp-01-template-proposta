package com.zup.proposta.validations;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Component
public class ValidaBase64Validador implements ConstraintValidator<ValidaBase64, String> {

    @Override
    public boolean isValid(String charSequence, ConstraintValidatorContext context) {
        String regex =
                "([A-Za-z0-9+/]{4})*" +
                        "([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(charSequence).matches();
    }
}
