package de.aw3s.btDiary.security;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PassphraseValidatorTest {

    @Test
    public void testPasswords(){
        isWeakPassword("aO1SHOsTY");//Minimum 1 non alphanumeric character
        isWeakPassword("AO1SHO!TY");//Minimum 1 lower case character
        isWeakPassword("aosho!ty");//Minimum 1 upper case character
        isWeakPassword("Tosho!ty");//Minimum 1 digit
        isWeakPassword("To1ho!t"); //Minimum length 8
        isWeakPassword("To!12345678"); //Number Sequences not allowed
        isWeakPassword("To!ABCDEFGH"); //Alphabetic Sequences not allowed
        isWeakPassword("To!qwertzui"); //QWERTY Sequences not allowed
        isWeakPassword("To!AAAAAAAA"); //Repeat Characters not allowed

        isStrongPassword("To!138ad");
    }



    private void isWeakPassword(String password) {
        assertFalse(new PassphraseValidator().validate(password));
    }

    private void isStrongPassword(String password) {
        assertTrue(new PassphraseValidator().validate(password));
    }
}
