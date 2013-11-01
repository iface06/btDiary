package de.aw3s.btDiary;

import de.aw3s.btDiary.application.registerUser.RegisterUserDao;
import de.aw3s.btDiary.application.registerUser.RegisterUserInteractor;
import de.aw3s.btDiary.application.registerUser.RegisterUserRequest;
import de.aw3s.btDiary.application.registerUser.RegisterUserResponse;
import org.junit.Test;
import static org.junit.Assert.*;

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
