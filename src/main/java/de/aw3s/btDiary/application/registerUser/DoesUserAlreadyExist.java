package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.tValidation.ConstraintViolation;
import de.aw3s.btDiary.tValidation.ConstraintViolationType;
import de.aw3s.btDiary.validation.Validator;
import de.aw3s.btDiary.validation.Violation;

import java.util.List;

public class DoesUserAlreadyExist implements Validator<RegisterUserRequest> {
    private RegisterUserDao dao;

    @Override
    public Violation validate(RegisterUserRequest userRegistration, String propertyName) {
        List<User> alreadyRegisteredUsers = findActiveUserWithEmailAddress(userRegistration.getEmailAddress());
        return alreadyRegisteredUsers.isEmpty() ? null : userAlreadyExistViolation(userRegistration, propertyName);
    }

    public void setDao(RegisterUserDao dao) {
        this.dao = dao;
    }

    protected Violation<RegisterUserRequest> userAlreadyExistViolation(RegisterUserRequest user, String propertyName) {
        return new ConstraintViolation<>(user, propertyName, ConstraintViolationType.AlREADY_EXIST);
    }

    protected List<User> findActiveUserWithEmailAddress(String emailAddress) {
        return dao.findUserByEmailAddress(emailAddress);
    }
}
