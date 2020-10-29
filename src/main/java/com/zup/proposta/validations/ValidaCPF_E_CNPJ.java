package com.zup.proposta.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ValidaCPF_CNPJ.class})

public @interface ValidaCPF_E_CNPJ {
    String message() default "{valida.documento}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
