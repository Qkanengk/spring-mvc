package com.codegym.ung_dung_nghe_nhac.utils.annotations;

import com.codegym.ung_dung_nghe_nhac.utils.validators.SongURLValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SongURLValidator.class)
@Documented
public @interface ValidSongURL {
    String message() default "Vui lòng nhập URL youtube";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
