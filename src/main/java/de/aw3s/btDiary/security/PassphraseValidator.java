package de.aw3s.btDiary.security;

import de.aw3s.btDiary.validation.Violation;
import edu.vt.middleware.password.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PassphraseValidator implements PassphraseValidationFunction{

    public static final int NOT_ALLOWED_NUMBER_OF_REPEATED_CHARACTERS = 3;
    public static final int NOT_ALLOWED_NUMBER_OF_NUMERICAL_SEQUENCE = 3;
    public static final int NOT_ALLOWED_NUMBER_OF_ALPHABETICAL_SEQUENCE = 3;

    private List<Rule> rules = new ArrayList<>();
    private PasswordValidator validator = new PasswordValidator(rules);


    public boolean validate(String password) {
        setUpRules();
        PasswordData pwd = createPassword(password);
        return validator.validate(pwd).isValid();
    }

    @Override
    public List<? extends Violation> getViolations() {
        return Collections.EMPTY_LIST;
    }

    private PasswordData createPassword(String s) {
        return new PasswordData(new Password(s));
    }

    private void setUpRules() {
        CharacterCharacteristicsRule charRule = new CharacterCharacteristicsRule();
        charRule.getRules().add(new DigitCharacterRule(1));    //mindestens eine Zahl
        charRule.getRules().add(new NonAlphanumericCharacterRule(1)); //mindestens ein Sonderzeichen
        charRule.getRules().add(new UppercaseCharacterRule(1)); //mindestens ein Großbuchstabe
        charRule.getRules().add(new LowercaseCharacterRule(1)); //mindestens ein Kleinbuchstabe
        charRule.setNumberOfCharacteristics(4);
        rules.add(charRule);
        rules.add(new NumericalSequenceRule(NOT_ALLOWED_NUMBER_OF_NUMERICAL_SEQUENCE, true));    //123456...
        rules.add(new AlphabeticalSequenceRule(NOT_ALLOWED_NUMBER_OF_ALPHABETICAL_SEQUENCE, true));  //ABCDEF...
        rules.add(new QwertySequenceRule());
        rules.add(new RepeatCharacterRegexRule(NOT_ALLOWED_NUMBER_OF_REPEATED_CHARACTERS)); //AAAA...
        rules.add(new LengthRule(8, 16));
        rules.add(new WhitespaceRule());
        rules.add(new DigitCharacterRule(1));    //mindestens eine Zahl
    }




}
