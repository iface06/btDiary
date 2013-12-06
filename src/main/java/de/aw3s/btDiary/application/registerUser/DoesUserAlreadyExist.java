package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.tValidation.ConstraintViolation;
import de.aw3s.btDiary.tValidation.ConstraintViolationType;
import de.aw3s.btDiary.validation.Validator;
import de.aw3s.btDiary.validation.Violation;
import java.util.List;

public class DoesUserAlreadyExist implements Validator<User> {
    private RegisterUserDao dao;

    @Override
    public Violation validate(User user, String propertyName) {
        List<User> alreadyRegisteredUsers = findActiveUserWithEmailAddress(user.getEmailAddress());
        return alreadyRegisteredUsers.isEmpty() ? null : userAlreadyExistViolation(user, propertyName);
    }

    public void setDao(RegisterUserDao dao) {
        this.dao = dao;
    }

    protected Violation<User> userAlreadyExistViolation(User user, String propertyName) {
        return new ConstraintViolation<User>(user, propertyName, ConstraintViolationType.AlREADY_EXIST);
    }

    protected List<User> findActiveUserWithEmailAddress(String emailAddress) {
        return dao.findUserByEmailAddress(emailAddress);
    }
}
