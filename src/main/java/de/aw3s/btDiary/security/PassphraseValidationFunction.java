package de.aw3s.btDiary.security;

import de.aw3s.btDiary.validation.Violation;

import java.util.List;

public interface PassphraseValidationFunction {

    boolean validate(String password);
    List<? extends Violation> getViolations();
}
