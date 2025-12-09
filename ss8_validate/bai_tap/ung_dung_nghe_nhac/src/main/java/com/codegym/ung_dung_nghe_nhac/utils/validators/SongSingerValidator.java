package com.codegym.ung_dung_nghe_nhac.utils.validators;

import com.codegym.ung_dung_nghe_nhac.utils.annotations.ValidSongSinger;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SongSingerValidator implements ConstraintValidator<ValidSongSinger, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return s.matches("^[a-zA-Z]+(?: [a-zA-Z]+)*$");
    }
}
