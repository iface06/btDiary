package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.tValidation.ConstraintViolationType;
import de.aw3s.btDiary.validation.Violation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static de.aw3s.btDiary.tValidation.ViolationAssert.assertViolation;
import static org.junit.Assert.assertNull;

public class DoesAccountWithEmailAddressAlreadyExistTest {

    private DoesUserAlreadyExist validator;
    private RegisterUserRequest user;
    private static List<User> users;
    RegisterUserDao dao = new RegisterUserDao() {
        @Override
        public List<User> findUserByEmailAddress(String emailAddress) {
            return users;
        }

        @Override
        public User store(User user) {
            return new User();
        }
    };

    @Before
    public void before(){
        users = new ArrayList<>();
        user = createRegisterUserReqeust("test@test.lo");
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

    private RegisterUserRequest createRegisterUserReqeust(String emailAddress) {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmailAddress(emailAddress);
        return request;
    }



}
