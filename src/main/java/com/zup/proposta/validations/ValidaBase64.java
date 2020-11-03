package com.zup.proposta.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ValidaBase64Validador.class})
public @interface ValidaBase64 {
    String message() default "Biometria deve estar em Base64";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
