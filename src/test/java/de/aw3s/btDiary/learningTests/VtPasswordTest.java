package de.aw3s.btDiary.learningTests;


import edu.vt.middleware.password.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VtPasswordTest {

    private List<Rule> rules;
    private PasswordValidator validator;

    @Test
    public void toShortPassword(){
        LengthRule lengthRule = new LengthRule(8, 16);
        rules.add(lengthRule);


        RuleResult result = validate("1234");

        assertFalse(result.isValid());
        assertEquals(1, result.getDetails().size());
    }

    @Test
    public void containsWhitespaces(){

        WhitespaceRule rule = new WhitespaceRule();
        before();
        rules.add(rule);

        RuleResult result = validate(" 1 23 4");

        assertFalse(result.isValid());
        assertEquals(1, result.getDetails().size());
    }

    @Test
    public void requiredCharacters(){

        CharacterCharacteristicsRule charRule = new CharacterCharacteristicsRule();
        charRule.getRules().add(new DigitCharacterRule(1));    //mindestens eine Zahl
        charRule.getRules().add(new NonAlphanumericCharacterRule(1)); //mindestens ein Sonderzeichen
        charRule.getRules().add(new UppercaseCharacterRule(1));
        charRule.getRules().add(new LowercaseCharacterRule(1));


        charRule.setNumberOfCharacteristics(4);

        rules.add(charRule);
        RuleResult result = validate("1!Ab");
        assertTrue(result.isValid());


    }

    @Test
    public void noNumberSequences(){
        NumericalSequenceRule numSeqRule = new NumericalSequenceRule(3, true);
        rules.add(numSeqRule);

        RuleResult result = validate("90123");
        assertFalse(result.isValid());

    }
    @Test
    public void noAlphaSequences(){
        AlphabeticalSequenceRule alphaSeqRule = new AlphabeticalSequenceRule();  //ABCDEFG...
        rules.add(alphaSeqRule);

        RuleResult result = validate("phijklmn#n65");
        assertFalse(result.isValid());

    }
    @Test
    public void noQwertySequences(){
        QwertySequenceRule qwertySeqRule = new QwertySequenceRule();
        rules.add(qwertySeqRule);

        RuleResult result = validate("ASDFG");
        assertFalse(result.isValid());
    }
    @Test
    public void noCharactersSequences(){
        RepeatCharacterRegexRule repeatRule = new RepeatCharacterRegexRule(4);
        rules.add(repeatRule);

        RuleResult result = validate("6666");

        assertFalse(result.isValid());

    }

    @Before
    public void before() {
        rules = new ArrayList<>();
        validator = new PasswordValidator(rules);
    }

    private RuleResult validate(String password) {
        PasswordData pwd = createPassword(password);
        return validator.validate(pwd);
    }

    private PasswordData createPassword(String s) {
        return new PasswordData(new Password(s));
    }


}
