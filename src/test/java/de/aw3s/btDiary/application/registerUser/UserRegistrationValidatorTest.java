package de.aw3s.btDiary.application.registerUser;

import static de.aw3s.btDiary.tValidation.ConstraintViolationType.*;
import static de.aw3s.btDiary.tValidation.ViolationAssert.*;
import de.aw3s.btDiary.validation.Violation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class UserRegistrationValidatorTest {

    private RegisterUserRequest user;
    private UserRegistrationValidator validator;
    private List<User> alreadyExistingUsers = new ArrayList<>();
    private RegisterUserDao dao = new RegisterUserDao() {
        @Override
        public List<User> findUserByEmailAddress(String emailAddress) {
            return alreadyExistingUsers;
        }

        @Override
        public User store(User user) {
            return new User();
        }
    };



    @Test
    public void testValidUserRegistration(){
        List<? extends Violation> violations = validator.validate(user);

        assertTrue(violations.isEmpty());
    }

    @Before
    public void before() {
        validator = new UserRegistrationValidator();
        validator.setDao(dao);
        createValidUser();
    }

    @Test
    public void testPasswordIsBlank(){
        user.setPassword("");
        List<? extends Violation> violations = validator.validate(user);

        assertTrue(violations.size() == 2);
        assertViolation(violations.get(0), user, "password", BLANK);
        assertViolation(violations.get(1), user, "password", UNSAFE);
    }

    @Test
    public void testUserNameIsBlank(){
        user.setFirstName("");
        List<? extends Violation> violations = validator.validate(user);



        assertTrue(violations.size() == 1);
        assertViolation(violations.get(0), user, "firstName", BLANK);
    }

    @Test
    public void testEmailAddressIsBlank(){
        user.setEmailAddress("");
        List<? extends Violation> violations = validator.validate(user);

        assertTrue(violations.size() == 2);
        assertViolation(violations.get(0), user, "emailAddress", BLANK);
    }

    @Test
    public void testNotValidEmailAddress(){
        user.setEmailAddress("info--at--aw3s.net");
        List<? extends Violation> violations = validator.validate(user);

        assertTrue(violations.size() == 1);
        assertViolation(violations.get(0), user, "emailAddress", NON_VALID_EMAIL_ADDRESS);
    }

    private void createValidUser() {
        user = new RegisterUserRequest();
        user.setFirstName("Max");
        user.setLastName("Mustermann");
        user.setPassword("T!135ads");
        user.setEmailAddress("max@mustermann.local");
    }
}
