package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.security.HashFunction;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreateUserByRegisterUserRequestFunctionTest {


    @Test
    public void test(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("Max");
        request.setLastName("Mustermann");
        request.setEmailAddress("max@musterman.local");
        request.setPassword("13!Fl232");

        CreateUserByRegisterUserRequestFunction createFunction = new CreateUserByRegisterUserRequestFunction();
        User user = createFunction.apply(request);

        assertEquals(request.getFirstName(), user.getFirstName());
        assertEquals(request.getLastName(), user.getLastName());
        assertEquals(request.getEmailAddress(), user.getEmailAddress());
        assertEquals(HashFunction.sha(request.getPassword()), user.getPassword());
    }

}
