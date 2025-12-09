package com.codegym.ung_dung_nghe_nhac.utils.annotations;

import com.codegym.ung_dung_nghe_nhac.utils.validators.SongSingerValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SongSingerValidator.class)
@Documented
public @interface ValidSongSinger {
    String message() default "Tên không hợp lệ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
