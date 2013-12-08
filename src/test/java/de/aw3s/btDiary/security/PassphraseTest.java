package de.aw3s.btDiary.security;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PassphraseTest {

    @Test
    public void weakPassword(){
        Passphrase pw = new Passphrase("123456");
        pw.setValidator(new PassphraseValidator());
        assertFalse(pw.isStrong());
    }

    @Test
    public void strongPassword(){
        Passphrase pw = new Passphrase("A1bfs13!");
        pw.setValidator(new PassphraseValidator());
        assertTrue(pw.isStrong());
    }
}
