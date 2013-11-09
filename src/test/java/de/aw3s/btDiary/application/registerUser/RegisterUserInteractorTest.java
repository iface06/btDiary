package de.aw3s.btDiary.application.registerUser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegisterUserInteractorTest {


    @Test
    public void test(){
        RegisterUserInteractor interactor = new RegisterUserInteractor();
        interactor.setDao(new RegisterUserDao() {
        });

        RegisterUserResponse response = interactor.apply(new RegisterUserRequest());

        assertEquals(true, response.wasRegistrationSuccessfull());
    }


}
