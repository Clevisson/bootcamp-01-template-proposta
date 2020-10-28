package com.zup.proposta.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ValidatedCPFAndCNPJ.class})

public @interface ValidCPFAndCNPJ {
    String message() default "Documento precisa ter um formato valido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
