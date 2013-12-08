package de.aw3s.btDiary.security;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashFunctionTest {

    @Test
    public void test(){
        HashFunction f = new HashFunction();
        String password = "d345$sls";
        String passwordHash1 = HashFunction.sha(password);
        String passwordHash2 = HashFunction.sha(password);

        assertEquals(passwordHash1, passwordHash2);
    }
}
