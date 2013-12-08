package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.reflection.Reflactor;
import de.aw3s.btDiary.security.Passphrase;
import de.aw3s.btDiary.tValidation.ConstraintViolation;
import de.aw3s.btDiary.tValidation.ConstraintViolationType;
import de.aw3s.btDiary.validation.Validator;
import de.aw3s.btDiary.validation.Violation;

public class IsSafePassword<T> implements Validator<T> {

    @Override
    public Violation<T> validate(T o, String propertyName) {
        String password = new Reflactor().getProperty(o, propertyName);
        if(new Passphrase(password).isStrong()){
            return null;
        }
        return new ConstraintViolation<T>(o, propertyName, ConstraintViolationType.UNSAFE);
    }
}
