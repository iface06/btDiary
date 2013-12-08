package de.aw3s.btDiary.security;

public class Passphrase {

    private String clearPassword;
    private PassphraseValidationFunction validator = new PassphraseValidator();

    protected void setValidator(PassphraseValidationFunction validator) {
        this.validator = validator;
    }

    public Passphrase(String clear) {
        clearPassword = clear;
    }


    public boolean isStrong() {
        return validator.validate(clearPassword);
    }


}
