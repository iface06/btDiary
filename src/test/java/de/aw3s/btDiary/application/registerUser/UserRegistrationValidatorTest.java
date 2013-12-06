package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.tValidation.ConstraintViolationType;
import de.aw3s.btDiary.validation.Violation;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class UserRegistrationValidatorTest {

    private User user;
    private UserRegistrationValidator validator;
    private List<User> alreadyExistingUsers = new ArrayList<>();
    private RegisterUserDao dao = new RegisterUserDao() {
        @Override
        public List<User> findUserByEmailAddress(String emailAddress) {
            return alreadyExistingUsers;
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

        assertTrue(violations.size() == 1);
        assertEquals(ConstraintViolationType.BLANK, violations.get(0).getType());
        assertEquals("password", violations.get(0).getPropertyName());
        assertEquals(user, violations.get(0).getOffender());

    }

    @Test
    public void testUserNameIsBlank(){
        user.setUserName("");
        List<? extends Violation> violations = validator.validate(user);

        assertTrue(violations.size() == 1);
        assertEquals(ConstraintViolationType.BLANK, violations.get(0).getType());
        assertEquals("userName", violations.get(0).getPropertyName());
        assertEquals(user, violations.get(0).getOffender());

    }

    @Test
    public void testEmailAddressIsBlank(){
        user.setEmailAddress("");
        List<? extends Violation> violations = validator.validate(user);

        assertTrue(violations.size() == 2);
        assertEquals(ConstraintViolationType.BLANK, violations.get(0).getType());
        assertEquals("emailAddress", violations.get(0).getPropertyName());
        assertEquals(user, violations.get(0).getOffender());
    }

    @Test
    public void testNotValidEmailAddress(){
        user.setEmailAddress("info--at--aw3s.net");
        List<? extends Violation> violations = validator.validate(user);

        assertTrue(violations.size() == 1);
        assertEquals(ConstraintViolationType.NON_VALID_EMAIL_ADDRESS, violations.get(0).getType());
        assertEquals("emailAddress", violations.get(0).getPropertyName());
        assertEquals(user, violations.get(0).getOffender());
    }



    private void createValidUser() {
        user = new User();
        user.setUserName("User");
        user.setPassword("123456");
        user.setEmailAddress("user@aw3s.de");
    }
}
