package de.aw3s.btDiary.application.registerUser;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RegisterUserInteractorTest {


    @Test
    public void test(){
        RegisterUserInteractor interactor = new RegisterUserInteractor();
        interactor.setDao(new RegisterUserDao() {
            @Override
            public List<User> findUserByEmailAddress(String emailAddress) {
                return Collections.EMPTY_LIST;
            }
        });

        RegisterUserResponse response = interactor.apply(new RegisterUserRequest());

        assertEquals(true, response.wasRegistrationSuccessfull());
    }


}
