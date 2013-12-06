package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.tValidation.ConstraintViolationType;
import de.aw3s.btDiary.validation.Violation;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static de.aw3s.btDiary.tValidation.ViolationAssert.assertViolation;

public class DoesAccountWithEmailAddressAlreadyExistTest {

    private DoesUserAlreadyExist validator;
    private User user;
    private static List<User> users;
    RegisterUserDao dao = new RegisterUserDao() {
        @Override
        public List<User> findUserByEmailAddress(String emailAddress) {
            return users;
        }
    };

    @Before
    public void before(){
        users = new ArrayList<>();
        user = createUser("test@test.lo");
        validator = new DoesUserAlreadyExist();
        validator.setDao(dao);
    }

    @Test
    public void userDoesNotAlreadyExist(){

        Violation<User> violation = validator.validate(user, "emailAddress");
        assertNull(violation);
    }

    @Test
    public void userAlreadyExist(){
        User userWithSameEmailAddress = createUser("test@test.lo");
        users.add(userWithSameEmailAddress );

        Violation<User> violation = validator.validate(user, "emailAddress");
        assertViolation(violation, user, "emailAddress", ConstraintViolationType.AlREADY_EXIST);
    }

    private User createUser(String emailAddress) {
        User user = new User();
        user.setEmailAddress(emailAddress);
        return user;
    }



}
