package com.codegym.ung_dung_nghe_nhac.utils.validators;

import com.codegym.ung_dung_nghe_nhac.utils.annotations.ValidSongURL;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SongURLValidator implements ConstraintValidator<ValidSongURL, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return s.matches("^((?:https?:)?\\/\\/)?((?:www|m)\\.)?((?:youtube(?:-nocookie)?\\.com|youtu.be))(\\/(?:[\\w\\-]+\\?v=|embed\\/|live\\/|v\\/)?)([\\w\\-]+)(\\S+)?$");
    }
}
