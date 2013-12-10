package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.tValidation.ConstraintViolationType;
import de.aw3s.btDiary.tValidation.ViolationAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegisterUserInteractorTest {

    private User user;
    private RegisterUserRequest request;
    private RegisterUserDao dao;
    private RegisterUserInteractor interactor;

    @Before
    public void before(){
        user = new User();
        request = new RegisterUserRequest();
        request.setFirstName("Max");
        request.setLastName("Mustermann");
        request.setEmailAddress("max@mustermann.local");
        request.setPassword("231!Fsl1");

        dao = new RegisterUserDao() {
            @Override
            public List<User> findUserByEmailAddress(String emailAddress) {
                return Collections.EMPTY_LIST;
            }

            @Override
            public User store(User user) {
                return new User();
            }
        };

        interactor = new RegisterUserInteractor();
        interactor.setDao(dao);
    }

    @Test
    public void completeFilledRegistration_tendsToSuccessfullRegistration(){
        RegisterUserResponse response = interactor.apply(request);
        assertTrue(response.isSuccess());
        assertTrue(response.getViolations().isEmpty());

    }

    @Test
    public void blankEmailAddress_tendsToViolations(){
        request.setEmailAddress("");
        RegisterUserResponse response = interactor.apply(request);

        assertFalse(response.isSuccess());
        assertFalse(response.getViolations().isEmpty());
        ViolationAssert.assertViolation(response.getViolations().get(0), request, "emailAddress", ConstraintViolationType.BLANK);
    }
}
